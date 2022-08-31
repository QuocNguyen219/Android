const lblA = document.createElement("label");
lblA.innerText = "Param a";
document.body.appendChild(lblA);




const txtA = document.createElement("input");
document.body.appendChild(txtA);

document.body.appendChild(document.createElement("br"));
document.body.appendChild(document.createElement("br"));

const lblB = document.createElement("label");
lblB.innerText = "Param b";
document.body.appendChild(lblB);

const txtB = document.createElement("input");
document.body.appendChild(txtB);



document.body.appendChild(document.createElement("br"));
document.body.appendChild(document.createElement("br"));


const lblKQ = document.createElement("label");
lblKQ.innerText = "Result";
document.body.appendChild(lblKQ);

const txtKQ = document.createElement("input");
document.body.appendChild(txtKQ);



document.body.appendChild(document.createElement("br"));
document.body.appendChild(document.createElement("br"));

const btnSum = document.createElement("button");
btnSum.innerText = "Sum";
document.body.appendChild(btnSum);

btnSum.onclick = function() {

    var avalue = parseInt(txtA.value);
    var bvalue = parseInt(txtB.value);
    txtKQ.setAttribute('value', avalue + bvalue);

}