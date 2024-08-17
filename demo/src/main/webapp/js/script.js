JavaScript
const popup = document.getElementById("popup");
const openPopup = document.getElementById("openPopup");
const closePopup = document.getElementsByClassName("close")[0];

openPopup.onclick = function() {
  popup.style.display = "block";
}

closePopup.onclick = function() {
  popup.style.display = "none";
}

window.onclick   
 = function(event) {
  if (event.target == popup) {
    popup.style.display = "none";
  }
}