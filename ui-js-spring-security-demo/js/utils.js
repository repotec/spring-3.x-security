let utils = {
    getCookie: function(name){
        let cookie = {};
        document.cookie.split(';').forEach(function(el) {
        let [k,v] = el.split('=');
        cookie[k.trim()] = v;
        })
        return cookie[name];
    },

    getCsrfTokenCookie(){
        let csrfToken = utils.getCookie('XSRF-TOKEN');
        console.log('csrfToken:' + csrfToken);
        return csrfToken;
    },

    getSessionValue(name){
        return window.sessionStorage.getItem(name);
    },

    putSessionValue(name, value){
        return window.sessionStorage.setItem(name, value)
    },

    getCsrfTokenFromSession(){
        return window.sessionStorage.getItem("XSRF-TOKEN");
    }
}