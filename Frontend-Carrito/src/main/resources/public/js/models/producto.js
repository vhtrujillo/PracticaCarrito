var app = angular.module('appProducto',[]);

app.controller('productoController', function($scope, $http) {
	
	$scope.producto={};
	$scope.productos=[];
	$scope.accion= 0; //1-agregar,0-ver,3-editar,
//	$scope.obtenerListaUsuarios = function(){
//		
//		$http({
//			url:'/usuario',
//			method:"GET"
//		}).then(function(response){
//			console.log(response.data);
//		}, function(response){
//			console.log(response);
//		});
//		$scope.hacerAccion(0);
//	};
	
	$scope.verProductos = function() {
		$http({
			url:'/producto',
			method:"GET"
		}).then(function(response){
			$scope.productos=response.data;// LLENA LA LISTA 
			console.log(response.data);
		}, function(response){
			console.log(response);
		});
	};
	
	$scope.verAccion = function(accion) {
		return accion === $scope.accion;
	}
	$scope.hacerAccion = function(accion) {
		   $scope.accion = accion;
	}
	
	$scope.guardarProducto = function(producto) {
		$http({
			url:'/producto',
			method:"POST",
			data: producto
		}).then(function(response){
			console.log(response.data);
			$scope.verProductos();
			$scope.hacerAccion(0);
		}, function(response){
			console.log(response);
		});
	};
	
	$scope.eliminarProducto = function(producto) {
		$http({
			url:'/producto',
			method:"DELETE",
			data: producto
		}).then(function(response){
			console.log(response.data);
			$scope.verProductos();
		}, function(response){
			console.log(response);
		});
	};
	
	$scope.obtener = function(producto)
	{
		$scope.producto = producto;
		$scope.hacerAccion(2);
	};
	$scope.actualizarProducto = function(producto) {
		$http({
			url:'/producto',
			method:"PUT",
			data: producto
		}).then(function(response){
			console.log(response.data);
			$scope.verProductos();
			$scope.hacerAccion(0);
		}, function(response){
			console.log(response);
		});
	};

	
});