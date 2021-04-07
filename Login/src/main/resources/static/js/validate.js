function validate() {
	var name = document.getElementById("name").value;
	var password=document.getElementById("password").value;
	
	if (name == '' || password == '') {
		alert('Please fill all fields.');
		return false;
	} else {
		return true;
	}
}