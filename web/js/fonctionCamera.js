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

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=0', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);  
    } else if (typeCamera == "SONY"){
        
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Move=up,8', true);
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


        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=2', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    }else if (typeCamera == "SONY"){
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Move=down,8', true);
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
        

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=4', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else if(typeCamera == "SONY"){
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Move=left,8', true);
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
 
        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=6', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    } else if(typeCamera == "SONY"){
        
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Move=right,8', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
        
    } else {
        alert("Camera non selectioné");
    }
}

function auto()
{
    http = createRequestObject();
    alert("Test")
    
    if(typeCamera == "HEDEN"){

        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=28', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);

       
       
        
    }

}

function onload(){
    if(typeCamera == "SONY"){
        //document.getElementById('image3').style.visibility = "visible";
        //document.getElementById('image4').style.visibility = "visible";
        document.getElementById('image3').style.display = "block";
        document.getElementById('image4').style.display = "block";
        
    } else if(typeCamera == "HEDEN"){
        //document.getElementById('image2').style.visibility = "visible";
        //document.getElementById('image1').style.visibility = "visible";
        document.getElementById('image1').style.display = "block";
        document.getElementById('image2').style.display = "block";
        
    }
}
function zoom()
{
    http = createRequestObject();
    if(typeCamera == "SONY"){

    
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?AreaZoom=0,0,250,250', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    }
} 

function dezoomer()
{
    http = createRequestObject();
    if(typeCamera == "SONY"){

    
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?AreaZoom=0,0,650,650', true); 
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    }
}

function stop()
{
    http = createRequestObject();
    if(typeCamera == "HEDEN"){

    
        http.open('GET', 'http://'+ip+'/decoder_control.cgi?user=admin&pwd=marvin&command=1', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
    }    
    else if(typeCamera == "SONY"){
        
        http.open('GET', 'http://'+ip+'/command/ptzf.cgi?Move=stop,motor', true);
        http.onreadystatechange = handleAJAXReturn;
        http.send(null);
            
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

