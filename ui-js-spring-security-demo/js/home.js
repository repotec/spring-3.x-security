document.querySelector('#b1').addEventListener('click', () => {
  const xcsrfTokenSession = utils.getCsrfTokenFromSession();
  const headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfTokenSession,
  };

  api
    .getService('account', headers)
    .then((response) => response.json())
    .then((data) => {
      alert(data);
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b2').addEventListener('click', () => {
  const xcsrfTokenSession = utils.getCsrfTokenFromSession();
  const headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfTokenSession,
  };

  api
    .getService('about/get', headers)
    .then((response) => response.json())
    .then((data) => {
      alert(JSON.stringify(data));
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b3').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  api
    .postService('about/new/HELLO', null, headers)
    .then((response) => {
      console.log(response);
    })
    .catch((error) => {
      console.log(error);
    });
});

document.querySelector('#b4').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  let data = {
    name: 'ahmed',
    email: 'sample@test.com',
    subject: 'create account',
    message: 'creating saving account',
  };

  api
    .postService('contact', data, headers)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert(
        data['name'] +
          ' ' +
          data.email +
          ' ' +
          data.subject +
          ' ' +
          data.message
      );
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b5').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  api
    .postService('balance', null, headers)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert(data);
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b6').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  api
    .getService('notice', headers)
    .then((response) => response.json())
    .then((data) => {
      alert(JSON.stringify(data));
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b7').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  api
    .getService('card', headers)
    .then((response) => response.json())
    .then((data) => {
      alert(JSON.stringify(data));
    })
    .catch((error) => {
      alert(error);
    });
});

document.querySelector('#b8').addEventListener('click', () => {
  let username = utils.getSessionValue('username');
  let password = utils.getSessionValue('password');
  let xcsrfToken = utils.getSessionValue('XSRF-TOKEN');

  let headers = {
    'Content-Type': 'application/json',
    'X-XSRF-TOKEN': xcsrfToken,
    Authorization: 'Basic ' + btoa(username + ':' + password),
  };

  let data = {
    cardNumber: '3333-2222-6666-2222',
    numer: 'samir ali',
    expireDate: '06/22',
  };

  api
    .updateService('card', data, headers)
    .then((response) => response.json())
    .then((data) => {
      alert(data);
    })
    .catch((error) => {
      alert(error);
    });
});
