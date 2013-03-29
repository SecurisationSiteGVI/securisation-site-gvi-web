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
    
    if(typeCamera == "HEDEN"){

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=0&onestep=1', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);  
    } else if (typeCamera == "SONY"){
        
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=0801', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
        
        
        
    }else {
        alert("Camera non selectioner");
    }

    
}

function bas()
{
    http = createRequestObject();
    if(typeCamera == "HEDEN"){


        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=2&onestep=1', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    }else if (typeCamera == "SONY"){
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=0201', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
        
        
    }else {
        alert("Camera non selectioné");
    }
}

function gauche()
{
    http = createRequestObject();
    if(typeCamera == "HEDEN"){
        

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=4&onestep=1', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else if(typeCamera == "SONY"){
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=0401', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
        
    }else {
        alert("Camera non selectioné")
    }
    
}

function droite()
{
   
    http = createRequestObject();
    if(typeCamera == "HEDEN"){
 
        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=6&onestep=1', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else if(typeCamera == "SONY"){
        
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=0601', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
        
    } else {
        alert("Camera non selectioné");
    }
}

function auto()
{
    http = createRequestObject();
    
    if(typeCamera == "HEDEN"){

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=28', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    //    } else if(typeCamera == "SONY"){
        
    //        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=', true);
    //        http.onreadystatechange = handleAJAXReturn;
    //        http.send(null);
          
        
        
    }
    else {
        alert("La fonction n'est pas disponible sur cette camera");
    }

}

function zoom()
{
    http = createRequestObject();
    if(typeCamera == "SONY"){

    
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?AreaZoom=0,0,250,250', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else {
        alert("La fonction n'est pas disponible sur cette camera");
    }
    
}

function dezoomer()
{
    http = createRequestObject();
    if(typeCamera == "SONY"){

    
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?AreaZoom=0,0,650,650', true); 
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else {
        alert("La fonction n'est pas disponible sur cette camera");
    }
}

function stop()
{
    http = createRequestObject();
    if(typeCamera == "HEDEN"){

    
        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=29', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    //    } else if(typeCamera == "SONY"){
    //        
    //        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Relative=', true);
    //        http.onreadystatechange = handleAJAXReturn;
    //        http.send(null);
    //        
    } else {
        alert("La fonction n'est pas disponible sur cette camera");
    }

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

