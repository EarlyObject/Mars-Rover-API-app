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
let userId;
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
    marsRoverType = document.getElementById('marsApiRoverData').value;
   /* if (marsRoverType == null || marsRoverType === '')
        marsRoverType = "Curiosity";*/

    marsSol = document.getElementById('marsSol').value;
   /* if (marsSol == null || marsSol === '' || marsSol < 0)
        marsSol = 2;*/

    userId = urlParams.get('userId');
    if (userId == null || userId === '') {
        userId = localStorage.getItem(userId);
        if (userId == null) {
            document.getElementById('createUser').value = true;
        }
    }
    if (userId != null && userId !== '') {
        localStorage.setItem('userId', userId);
        document.getElementById('userId').value = userId;
    }
}