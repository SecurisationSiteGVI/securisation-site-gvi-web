var http; // Notre objet XMLHttpRequest

function createRequestObject()
{
    var http;
    if (window.XMLHttpRequest)
    { // Mozilla, Safari, IE7 ...
        http = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    { // Internet Explorer 6
        http = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return http;
}

function haut()
{
    http = createRequestObject();

    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=0&onestep=1', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
}

function bas()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=2&onestep=1', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
}

function gauche()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=4&onestep=1', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
}

function droite()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=6&onestep=1', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
}

function auto()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=28', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);

}

function stop()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/decoder_control.cgi?user=admin&pwd=marvin&command=29', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);

}

function allumeLED()
{
    
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/set_misc.cgi?led_mode=1&user=admin&pwd=marvin', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
}

    

function eteindreLED()
{
    http = createRequestObject();
    
    http.open('POST', 'http://172.16.79.214/set_misc.cgi?led_mode=2&user=admin&pwd=marvin', true);
    http.onreadystatechange = handleAJAXReturn;
    http.send(null);
    
    
 }


    
function handleAJAXReturn()
{
    //alert('handleAJAXReturn');
    if (http.readyState == 4)
    {
        if (http.status == 200)
        {
            document.getElementById('resultat').innerHTML = http.responseText;
        }

    }
}

