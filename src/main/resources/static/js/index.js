let marsApiButtons = document.querySelectorAll("label[id*='marsApi']")

marsApiButtons.forEach(button => button.addEventListener("click", function (){
    const buttonId = this.id
    const roverId = buttonId.split("marsApi")[1]
    let apiData = document.getElementById("marsApiRoverData")
    apiData.value = roverId
    document.getElementById("frmRoverType").submit()
}))

let marsRoverType = getMarsRoverType();
let element;
element = document.getElementById("marsApi" + marsRoverType);
element.classList.remove("btn-outline-secondary");
element.classList.add("btn-outline-primary");

function getMarsRoverType()
{
    let urlParams = new URLSearchParams(window.location.search);
    let entries = urlParams.entries();
    let marsRoverType;

    for(let pair of entries) {
        marsRoverType = pair[1];
    }
    if (marsRoverType == null)
        marsRoverType = "Curiosity";
    return (marsRoverType);
}