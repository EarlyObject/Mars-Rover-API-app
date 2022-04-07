let marsApiButtons = document.querySelectorAll("input[id*='marsApi']")

marsApiButtons.forEach(button => button.addEventListener("click", function (){
    const buttonId = this.id
    const roverId = buttonId.split("marsApi")[1]
    let apiData = document.getElementById("marsApiRoverData")
    apiData.value = roverId
    document.getElementById("frmRoverType").submit()
}))
let marsRoverType;
let marsSol;
getMarsRoverType();
let element;
element = document.getElementById("marsApi" + marsRoverType);
element.classList.remove("btn-outline-secondary");
element.classList.add("btn-outline-primary");
element.checked = true;


element = document.getElementById("marsSol");
element.value = marsSol;

function getMarsRoverType()
{
    let urlParams = new URLSearchParams(window.location.search);
    marsRoverType = urlParams.get('marsApiRoverData');
    if (marsRoverType == null || marsRoverType == "")
        marsRoverType = "Curiosity";

    marsSol = urlParams.get('marsSol');
    if (marsSol == null)
        marsSol = 1;
}