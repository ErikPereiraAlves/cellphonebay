'use strict';

angular.module('cellphonebay').controller('ProductController',
    ['ProductService', '$scope',  function( ProductService, $scope) {

        var self = this;
        self.product = {};
        self.products=[];

        self.submit = submit;
        self.getAllProducts = getAllProducts;
        self.createProduct = createProduct;
        self.updateProduct = updateProduct;
        self.removeProduct = removeProduct;
        self.editProduct = editProduct;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.Product.id === undefined || self.Product.id === null) {
                console.log('Saving New Product', self.Product);
                createProduct(self.Product);
            } else {
                updateProduct(self.Product, self.Product.id);
                console.log('Product updated with id ', self.Product.id);
            }
        }

        function createProduct(Product) {
            console.log('About to create Product');
            ProductService.createProduct(Product)
                .then(
                    function (response) {
                        console.log('Product created successfully');
                        self.successMessage = 'Product created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.Product={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Product');
                        self.errorMessage = 'Error while creating Product: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateProduct(Product, id){
            console.log('About to update Product');
            ProductService.updateProduct(Product, id)
                .then(
                    function (response){
                        console.log('Product updated successfully');
                        self.successMessage='Product updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Product');
                        self.errorMessage='Error while updating Product '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeProduct(id){
            console.log('About to remove Product with id '+id);
            ProductService.removeProduct(id)
                .then(
                    function(){
                        console.log('Product '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Product '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllProducts(){
            return ProductService.getAllProducts();
        }

        function editProduct(id) {
            self.successMessage='';
            self.errorMessage='';
            ProductService.getProduct(id).then(
                function (Product) {
                    self.Product = Product;
                },
                function (errResponse) {
                    console.error('Error while removing Product ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.Product={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);