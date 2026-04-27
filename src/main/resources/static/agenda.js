async function carregarAgenda(){

const data = document.getElementById("data").value

const response = await fetch("http://localhost:8080/agendamentos/1/" + data)

const agendamentos = await response.json()

const horarios = [
"09:00",
"09:30",
"10:00",
"10:30",
"11:00",
"11:30",
"12:00",
"13:00",
"13:30",
"14:00",
"14:30",
"15:00",
"15:30",
"16:00",
"16:30",
"17:00",
"17:30",
"18:00"
]

let html = ""

horarios.forEach(hora => {

let ana = ""
let paula = ""
let carla = ""

agendamentos.forEach(a => {

if(a.hora === hora){

const texto = a.cliente.nome + " (" + a.servico.nome + ")"

if(a.profissional.nome === "Ana") ana = texto
if(a.profissional.nome === "Paula") paula = texto
if(a.profissional.nome === "Carla") carla = texto

}

})

html += `
<tr>
<td>${hora}</td>
<td>${ana}</td>
<td>${paula}</td>
<td>${carla}</td>
</tr>
`

})

document.getElementById("agenda").innerHTML = html

}