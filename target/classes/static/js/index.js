// app.js
angular.module('myApp').controller('landingController', function ($scope, $http) {
    $scope.tours = [];
    $scope.cart = [];
    // Function to fetch tour products from the API
    $scope.getTours = function () {
      // Replace 'YOUR_GET_TOURS_API_URL' with the actual API endpoint to fetch tour products
      var getToursApiUrl = 'http://localhost:8080/api/products';

      $http.get(getToursApiUrl)
        .then(function (response) {
          // Store the fetched tour products in the $scope.tours array
          $scope.tours = response.data;
        })
        .catch(function (error) {
          console.error('Error fetching tour products:', error);
        });
    };

    $scope.logout = function () {
      window.location.href =  'http://localhost:8080/auth/logoff';
    }

    // Function to fetch tour products from the API
    $scope.getAccount = function () {

      // Replace 'YOUR_GET_TOURS_API_URL' with the actual API endpoint to fetch tour products
      var getAccountApiURL = 'http://localhost:8080/api/account';

      $http.get(getAccountApiURL)
        .then(function (response) {
          // Store the fetched tour products in the $scope.tours array
          $scope.account = response.data;
        })
        .catch(function (error) {
          console.error('Error fetching account:', error);
        });
    };

    // Function to add a tour product to the cart
    $scope.addToCart = function (tour) {
      // Replace 'YOUR_ADD_TO_CART_API_URL' with the actual API endpoint to add a tour product to the cart
      var addToCartApiUrl = 'http://localhost:8080/api/cart';

      

      $http.post(addToCartApiUrl, tour)
        .then(function (response) {
          // Handle success message or update the cart in the UI
          console.log('Added to cart:', tour.name);

           // If the tour is not in the cart, add it
            $scope.cart.push({
            name: tour.name,
            price: tour.price
          });
        })
        .catch(function (error) {
          alert('Error adding to cart:');
        });
    };

    // Fetch tour products when the controller loads
    $scope.getTours();
    $scope.getAccount();
  });
