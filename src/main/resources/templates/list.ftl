<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Specific Product </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.product.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="productName">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.productName" id="productName" class="productname form-control input-sm" placeholder="Enter name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="productDesc">Descr</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.productDesc" id="productDesc" class="form-control input-sm" placeholder="Enter description." required ng-minlength="3" />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="productPrice">Price</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.productPrice" id="productPrice" class="form-control input-sm" placeholder="Enter unit price." required ng-pattern="ctrl.onlyNumbers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="productAvailable">Availability</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.product.productAvailable" id="productAvailable" class="form-control input-sm" placeholder="Enter availability." required ng-pattern="ctrl.onlyNumbers"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.product.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Products </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>NAME</th>
                        <th>DESCRIPTION</th>
                        <th>PRICE</th>
                        <th>AVAILABILITY</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="prdct in ctrl.getAllProducts()">
                        <td>{{prdct.productName}}</td>
                        <td>{{prdct.productDesc}}</td>
                        <td>{{prdct.productPrice}}</td>
                        <td>{{prdct.productAvailable}}</td>
                        <td><button type="button" ng-click="ctrl.editProduct(prdct.productId)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeProduct(prdct.productId)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>