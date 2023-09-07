const formulario = document.querySelector("form");
const inputEmail = document.querySelector(".email");
const inputSenha = document.querySelector(".senha");


function cadastrar(){
    //conectar o front
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