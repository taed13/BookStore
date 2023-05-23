let user = {};

function redirect(url) {
    window.location.href = url;
}

function handleLogin() {
    const email_address = document.getElementById('email-address').value;
    const password = document.getElementById('password').value;

    const data_login = {
        email: email_address,
        password: password
    }

    axios.post('https://pbl-be-production.up.railway.app/api/login', data_login)
        .then(response => {
            console.log(response.data);

            // user = JSON.stringify(response.data.data);
            var temp = JSON.stringify(response.data.data);
            localStorage.setItem('user', JSON.stringify(response.data.data));
            localStorage.setItem('token', response.data.token);
            console.log(response.data.token, response.data.data);
            console.log(JSON.stringify(response.data.data), JSON.parse(temp));

            redirect('view-account.html');


        })
        .catch(error => {
            console.error(error);
        });
}
