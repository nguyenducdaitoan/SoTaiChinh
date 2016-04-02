<!DOCTYPE html>
<html>
  <head>
    <title>Google Maps JavaScript API v3 Example: Map Simple</title>
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta charset="UTF-8">
    <style type="text/css">
      html, body, #map_canvas {
        margin: 0;
        padding: 0;
        height: 100%;
      }
    </style>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">
      var map;
      var myLatLng = new google.maps.LatLng(16.080213,108.222713);
      function initialize() {
        var myOptions = {
          zoom: 17,
          zoomControl: false,
          scaleControl: true,
          panControl: false,
          streetViewControl: false,
          overviewMapControl: false,
          mapTypeControl: false,           
          center: myLatLng,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        map = new google.maps.Map(document.getElementById('map_canvas'), myOptions);
        
        var marker = new google.maps.Marker({
            position: myLatLng,
            map: map,
            title: 'Sở tài chính thành phố Đà Nẵng 12 Trần Phú - Hải Châu - thành phố Đà Nẵng'
        });
        var infowindow = new google.maps.InfoWindow({
			  content: "<div style=\"color: blue; font-weight: bold; font-family: Arial; font-size: 0.8em\">Sở tài chính thành phố Đà Nẵng</div><div style=\"font-family: Arial; font-size: 0.8em\">Địa chỉ: 12 Trần Phú - Hải Châu - thành phố Đà Nẵng</div><div style=\"font-family: Arial; font-size: 0.8em\">Điện thoại: (84.511) 3822130</div><div style=\"font-family: Arial; font-size: 0.8em\">Email: stcdanang@mof.gov.vn</div>",
			  maxWidth:350,
			  boxStyle: {
                 border: "1px solid black"                 
               },                                  
			  position: myLatLng,
			  pixelOffset: new google.maps.Size(-1, 0)
		});
        infowindow.open(map);        
      }

      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </head>
  <body>
    <div id="map_canvas"></div>
  </body>
</html>
