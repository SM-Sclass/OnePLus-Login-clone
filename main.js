const VRF = document.querySelector('.sign_button');
const num = document.querySelector('#number');
const pas = document.querySelector('#pass');


VRF.addEventListener('click' , action);
function action(e)
{

    if(num.value === '')
    {
       
        e.preventDefault();
        alert("Please enter your number");
    }
    else if(pas.value === '')
    {
        e.preventDefault();
        alert("Please enter your password");
    }
    else{
        alert("Welcome");
        console.log('done');
    }
}
