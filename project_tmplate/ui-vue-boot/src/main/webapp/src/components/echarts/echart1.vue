<template>
	 <div class="chart" v-echarts="barChartOption" ></div>
</template>

<script>
	 

  export default {
    data() {
      return {
			 barChartOption : {
				    tooltip: {},
				    xAxis: {
				        data: ['A', 'B', 'C', 'D', 'E']
				    },
				    yAxis: {},
				    series: [
				        {
				            name: 'Num',
				            type: 'bar',
				            data: [5, 20, 36, 10, 10, 20]
				        }
				    ]
				}
			 
     		}
    },
    methods: {
			 
    }
  }
</script>

<style scoped>
	.chart {
	    width: 100%;
	    height: 400px;
	}
</style>