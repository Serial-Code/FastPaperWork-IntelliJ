new Morris.Line({
  // ID of the element in which to draw the chart.
  element: 'myfirstchart',
  // Chart data records -- each entry in this array corresponds to a point on
  // the chart.
  data: [
    { year: '2008', value: 20 },
    { year: '2009', value: 10 },
    { year: '2010', value: 5 },
    { year: '2011', value: 5 },
    { year: '2012', value: 20 }
  ],
  // The name of the data record attribute that contains x-values.
  xkey: 'year',
  // A list of names of data record attributes that contain y-values.
  ykeys: ['value'],
  // Labels for the ykeys -- will be displayed when you hover over the
  // chart.
  labels: ['Value'],

 
});



Morris.Area({
  // ID of the element in which to draw the chart.
  element: 'GraficaClientes',
  // Chart data records -- each entry in this array corresponds to a point on
  // the chart.
  data: [
    { x: '2010 Q4', y:3, z:7},
    { x: '2011 Q1', y:3, z:4},
    { x: '2011 Q2', y:4, z:1},
    { x: '2011 Q3', y:2,z:5},
    { x: '2011 Q4', y:8,z:2},
    { x: '2012 Q1', y:4,z:4}
  ],
  // The name of the data record attribute that contains x-values.
  xkey: 'x',
  // A list of names of data record attributes that contain y-values.
  ykeys: ['y', 'z'],
  // Labels for the ykeys -- will be displayed when you hover over the
  // chart.
  labels: ['Y','Z']
}).on('click', function(i, row){
  console.log(i, row);
});


Morris.Donut({
  element: 'donut-example',
  data: [
    {label: "Total entradas", value: 12},
    {label: "Total Salidas", value: 30},
  ]

});
