function validate() {
  let username = document.getElementById('username').value;
  let password = document.getElementById('password').value;

  if (username !== '' && password !== '') {
    let headers = {
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(username + ':' + password),
    };

    api
      .getService('login', headers)
      .then((response) => {
        if (response.ok) console.log('user has been authenticated!');
        else alert(response.error);
      })
      .then((data) => {
        console.log('data:' + data);
      })
      .catch((error) => {
        alert(error);
      });

    //get the XSRF-TOKEN from cookies
    xcsrfToken = utils.getCsrfTokenCookie();

    if (xcsrfToken !== '') {
      //store the token into session
      utils.putSessionValue('XSRF-TOKEN', xcsrfToken);
      utils.putSessionValue('username', username);
      utils.putSessionValue('password', password);

      window.location = 'home.html';
    }
  } else {
    alert('please enter the username and password');
  }
}
