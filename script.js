const formulario = document.querySelector("form");
const inputEmail = document.querySelector(".email");
const inputSenha = document.querySelector(".senha");
const modal = document.getElementById('myModal');
const modalText = document.getElementById('modalText');


function exibirModal(mensagem) {
    modalText.textContent = mensagem;
    modal.style.display = 'block';
  
    setTimeout(function () {
      modal.style.display = 'none';
      inputEmail.value = '';
      inputSenha.value = '';
    }, 2000); // Ocultar o modal após 2 segundos
  }

function cadastrar(){
    var resp = false;
    //conectar o front
    Regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?!.*\s)(?!.*(.).*\1)(?=.*[!@#%^&*()-+]).{9,}$/;

    if(!Regex.test(inputSenha.value)){
     
        exibirModal(resp);
    }else{
    var resp = true;
    exibirModal(resp);
    fetch("http://localhost:8080/usuarios",
    {

        headers: {
            'Accept':'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            email: inputEmail.value,
            senha: inputSenha.value
        })
    })
    .then(function (res) { console.log(res)})
    .catch(function (res) { console.log(res)})
}
};

function limpar(){
    inputEmail.value = "";
    inputSenha.value = "";
};


formulario.addEventListener('submit', function(e){
    e.preventDefault();

    cadastrar();
    limpar();
    
});