const statics = { server_url: 'http://127.0.0.1:8000/' };

let api = {
  getService: async function (serviceName, headers) {
    const url = (await statics.server_url) + serviceName;
    console.log('url:' + url + '|method:GET|' + '|headers:' + headers);

    const response = fetch(url, {
      method: 'GET',
      headers: headers,
      credentials: 'include',
      mode: 'cors',
    });

    return response;
  },
  postService: async function (serviceName, data, headers) {
    const response = await fetch(statics.server_url + serviceName, {
      method: 'POST',
      headers: headers,
      credentials: 'include',
      body: JSON.stringify(data),
      mode: 'cors',
    });

    return await response;
  },

  updateService: async function (serviceName, data, _headers) {
    const response = await fetch(statics.server_url + serviceName, {
      method: 'POST',
      headers: _headers,
      credentials: 'include',
      body: JSON.stringify(data),
      mode: 'cors',
    });

    if (response.ok) {
      console.log(response);
      if (response.json.length != 0) return await response.json();
      else if (response.text != 0) {
        return await response.text();
      }
    } else {
      console.error(error);
    }
  },
};
