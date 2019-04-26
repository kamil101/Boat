$(function(){
	

$.ajax({
  type: "GET",
  url: "/api/trip/all-trip",
  success: function(trips){

  	// rowingboat(to know that http req is done
  	
  	

//loop
  	$.each(trips,function(index,trip){
  		//console.log(trip);

  		 var newRow = "<tr><th scope=\"row\">"+ 
  		 (index+1) + 
  		 "</th><td>"+
  trip.boatNumber +
   "</td><td>"+
   trip.startTime+ 
   "</td><td>"+
   trip.endTime+ 
   "</td><td>"+
   trip.tripCost
   + "</td></tr>";

   $(newRow).appendTo("#tabelBodyTrip");




  	})

  },

});

$.ajax({
  type: "GET",
  url: "/api/rowingboat/all-rowingboat",
  success: function(boats){

  	// rowingboat(to know that http req is done
  	
  	

//loop
  	$.each(boats,function(index,boat){
  		//console.log(trip);

  		 var newRow = "<tr><th scope=\"row\">"+ 
  		 (index+1) + 
  		 "</th><td>"+
  boat.boatNumber +
   "</td><td>"+
   boat.minPrice+ 
   "</td><td>"+
   boat.actPrice+ 
   "</td><td>"+
   boat.numberOfseats
   + "</td><td>"+
      boat.status
      +"</td></tr>";

   $(newRow).appendTo("#tabelBodyBoat");
})
  },

});


$("#btn1").click(function(){
  
  alert("inside func");
   var postData = {
        
      BoatNumber: $("#BoatNumber").val(),
        MinPrice: $("#MinPrice").val(),
        actPrice: $("#actPrice").val(),
        numberOfseats: $("#numberOfseats").val(),
        status: $("#status").val()
    };

$.ajax({
  type: "POST",
  url: "api/boat/add-single-rowingboat",
  data: JSON.stringify(postData),
  dataType:JSON,
  success: function(){
alert("boat is added");
  }

});

  
});

function rowingboat(){
  alert("inside func");
	 var postData = {
        
     	BoatNumber: $("#BoatNumber").val(),
        MinPrice: $("#MinPrice").val(),
        actPrice: $("#actPrice").val(),
        numberOfseats: $("#numberOfseats").val(),
        status: $("#status").val()
    };

$.ajax({
  type: "POST",
  url: "api/boat/add-single-rowingboat",
  data: JSON.stringify(postData),
  dataType:JSON,
	success: function(){
alert("boat is added");
  },

});
};

})










// alert("hi there");

// $.ajax({
//   type: "GET",
//   url: "http://localhost:8080/api/trip/all-trip",
//   data: {"name",""}
//   Console.log()
//   success: success,
 // fail: function(){
 //       alert('request failed'),
//   dataType: dataType
// });
