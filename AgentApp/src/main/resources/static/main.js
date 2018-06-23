(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error('Cannot find module "' + req + '".');
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/accomodation/accomodation.component.css":
/*!*********************************************************!*\
  !*** ./src/app/accomodation/accomodation.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-container {\r\n    display: flex;\r\n    flex-direction: column;\r\n  }\r\n  \r\n  .example-container > * {\r\n    width: 100%;\r\n  }\r\n  \r\n  .example-card {\r\n    max-width: 1000px;\r\n    margin: 20px auto;\r\n  }\r\n  \r\n  .mat-raised-button{\r\n    background-color: coral;\r\n  }\r\n  \r\n  mat-divider{\r\n    background-color:brown;\r\n  }\r\n  \r\n  .term{\r\n    padding: 10px;\r\n  }"

/***/ }),

/***/ "./src/app/accomodation/accomodation.component.html":
/*!**********************************************************!*\
  !*** ./src/app/accomodation/accomodation.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"example-card\">\n  <mat-card-content>\n    <form [formGroup]=\"form\" (ngSubmit)=\"onSubmit()\" style=\"margin-bottom: 20px\">\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter accomodation name\" formControlName=\"name\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter Country\" formControlName=\"country\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter City\" formControlName=\"city\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter Address\" formControlName=\"address\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n          <mat-form-field>\n              <mat-select placeholder=\"Choose your accomodation type\" formControlName=\"accomodationType\">\n                <mat-option *ngFor=\"let type of types\" [value]=\"type.id\">\n                  {{ type.type }}\n                </mat-option>\n              </mat-select>\n            </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n            <mat-select placeholder=\"Choose your accomodation category\" formControlName=\"category\">\n              <mat-option *ngFor=\"let category of categories\" [value]=\"category.id\">\n                {{ category.category }}\n              </mat-option>\n            </mat-select>\n          </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <textarea matInput placeholder=\"Description\" formControlName=\"description\"></textarea>\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"number\" matInput placeholder=\"Capacity\" formControlName=\"capacity\">\n        </mat-form-field>\n      </div>\n      <br><br>\n      <mat-divider></mat-divider>\n      <div formArrayName=\"terms\">\n        <h4>Your terms</h4>\n        <button mat-raised-button type=\"button\"\n        (click)=\"onAddTerm()\" [disabled]=\"!form.get('terms').valid\">Add term</button>\n        <div class=\"form-group\"\n        *ngFor=\"let termControl of form.get('terms').controls; let i = index\"> \n          <div  [formGroupName]=\"i\">\n            <mat-form-field class=\"term\">\n              <input matInput [matDatepicker]=\"pickerFrom\" placeholder=\"From\" class=\"form-control\" formControlName=\"startDate\">\n              <mat-datepicker-toggle matSuffix [for]=\"pickerFrom\"></mat-datepicker-toggle>\n              <mat-datepicker #pickerFrom></mat-datepicker>    \n            </mat-form-field>\n            <mat-form-field class=\"term\">\n              <input matInput [matDatepicker]=\"pickerTo\" placeholder=\"To\" class=\"form-control\" formControlName=\"endDate\">\n              <mat-datepicker-toggle matSuffix [for]=\"pickerTo\"></mat-datepicker-toggle>\n              <mat-datepicker #pickerTo></mat-datepicker>\n            </mat-form-field >\n            <mat-form-field class=\"term\" >\n                <input type=\"number\" matInput placeholder=\"Price\" class=\"form-control\" formControlName=\"price\">\n            </mat-form-field>\n          </div>\n        </div>\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <div formArrayName=\"additionalServices\">\n        <h4>Your additional services</h4>\n        <div *ngFor=\"let service of services\">\n         \n            <mat-checkbox [checked]=\"service.test\" (change)=\"onServiceCheck(service.id, $event)\">{{service.name}}</mat-checkbox>\n          \n        </div>\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <div>\n        <h4>Your images:</h4>\n        <input type=\"file\" multiple accept=\"image/*\" placeholder=\"Upload images\" (change)=\"onFileChanged($event)\">\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <button mat-raised-button color=\"warn\" type=\"submit\" [disabled]=\"!form.valid\">Save changes</button>\n    </form>\n  </mat-card-content>\n\n \n</mat-card>\n\n"

/***/ }),

/***/ "./src/app/accomodation/accomodation.component.ts":
/*!********************************************************!*\
  !*** ./src/app/accomodation/accomodation.component.ts ***!
  \********************************************************/
/*! exports provided: AccomodationComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AccomodationComponent", function() { return AccomodationComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AccomodationComponent = /** @class */ (function () {
    function AccomodationComponent(fb, snackBar, http, route, router) {
        this.fb = fb;
        this.snackBar = snackBar;
        this.http = http;
        this.route = route;
        this.router = router;
        this.services = [];
    }
    AccomodationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.id = this.route.snapshot.params.id;
        this.form = new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroup"]({
            'name': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'country': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'city': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'address': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'accomodationType': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'category': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'description': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null),
            'capacity': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'terms': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormArray"]([]),
            'additionalServices': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"]([])
        });
        this.http.get('http://localhost:8081/additionalServices').subscribe(function (data) {
            _this.services = data;
        });
        this.http.get('http://localhost:8081/accomodationTypes').subscribe(function (data) {
            _this.types = data;
        });
        this.http.get('http://localhost:8081/categories').subscribe(function (data) {
            _this.categories = data;
        });
        this.http.get('http://localhost:8081/accomodations/' + this.id + '/terms').subscribe(function (data) {
            _this.terms = data;
            _this.http.get('http://localhost:8081/accomodations/' + _this.id).subscribe(function (data) {
                _this.accomodation = data;
                var tempServices = [];
                _this.form = new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroup"]({
                    'name': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.name, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'country': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.country, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'city': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.city, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'address': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.address, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'accomodationType': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.accomodationType.id, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'category': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.category.id, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'description': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.description),
                    'capacity': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.accomodation.capacity, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                    'terms': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormArray"]([]),
                    'additionalServices': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"]([])
                });
                var niz = _this.form.get('additionalServices').value;
                for (var i = 0; i < _this.services.length; i++) {
                    for (var j = 0; j < _this.accomodation.additionalServices.length; j++) {
                        var tempSelectedService = _this.accomodation.additionalServices[j];
                        var tempService = _this.services[i];
                        if (tempService.id === tempSelectedService.id) {
                            tempService.test = true;
                            niz.push(tempSelectedService.id);
                        }
                    }
                }
                for (var i = 0; i < _this.terms.length; i++) {
                    var group = new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroup"]({
                        'startDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].startDate, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                        'endDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].endDate, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                        'price': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].price, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
                        'reserved': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].reserved),
                        'id': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].id),
                        'visited': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](_this.terms[i].visited)
                    });
                    _this.form.get('terms').push(group);
                }
            });
        });
    };
    AccomodationComponent.prototype.onAddTerm = function () {
        //const control = new FormControl(null,Validators.required);
        //(<FormArray>this.form.get('terms')).push(control);
        var group = new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroup"]({
            'startDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'endDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'price': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required),
            'reserved': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](false),
            'id': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](null),
            'visited': new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"](false)
        });
        this.form.get('terms').push(group);
    };
    // onTermReserve(term,event){
    //   (<FormArray>this.form.get('terms')).at((<FormArray>this.form.get('terms')).value.indexOf(term.value)).get('reserved').setValue(true);
    // }
    // onTermUnreserve(term,event){
    //   (<FormArray>this.form.get('terms')).at((<FormArray>this.form.get('terms')).value.indexOf(term.value)).get('reserved').setValue(false);
    // }
    AccomodationComponent.prototype.onServiceCheck = function (id, event) {
        var niz = this.form.get('additionalServices').value;
        if (event.checked) {
            niz.push(id);
        }
        else {
            var index = niz.indexOf(id);
            niz.splice(index, 1);
        }
    };
    AccomodationComponent.prototype.onSubmit = function () {
        var _this = this;
        if (this.form.valid) {
            this.http.put('http://localhost:8081/accomodations/' + this.id, this.form.value)
                .subscribe(function (data) {
                var id = data.id;
                var formData = new FormData();
                if (_this.images != null) {
                    for (var _i = 0, _a = _this.images; _i < _a.length; _i++) {
                        var image = _a[_i];
                        formData.append('image', image, image.name);
                    }
                    _this.http.post('http://localhost:8081/accomodations/' + id, formData)
                        .subscribe(function () {
                        _this.snackBar.open('Accomodation successfully modified.', 'Close', {
                            duration: 2000
                        });
                        _this.router.navigate(['']);
                    });
                }
                _this.router.navigate(['']);
            });
        }
    };
    AccomodationComponent.prototype.onFileChanged = function (event) {
        this.images = event.target.files;
    };
    AccomodationComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-accomodation',
            template: __webpack_require__(/*! ./accomodation.component.html */ "./src/app/accomodation/accomodation.component.html"),
            styles: [__webpack_require__(/*! ./accomodation.component.css */ "./src/app/accomodation/accomodation.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"],
            _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]])
    ], AccomodationComponent);
    return AccomodationComponent;
}());



/***/ }),

/***/ "./src/app/accomodations/accomodations.component.css":
/*!***********************************************************!*\
  !*** ./src/app/accomodations/accomodations.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\r\n    width: 100%;\r\n  }\r\n  \r\n  .mat-form-field {\r\n    font-size: 14px;\r\n    width: 80%;\r\n    padding: 20px;\r\n  }\r\n  \r\n  /* td, th {\r\n    width: 25%;\r\n  } */\r\n  \r\n  .cursor{\r\n    cursor: pointer;\r\n  }\r\n  "

/***/ }),

/***/ "./src/app/accomodations/accomodations.component.html":
/*!************************************************************!*\
  !*** ./src/app/accomodations/accomodations.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-form-field>\n  <input matInput (keyup)=\"applyFilter($event.target.value)\" placeholder=\"Filter\">\n</mat-form-field>\n\n<div class=\"mat-elevation-z8\">\n  <table mat-table [dataSource]=\"myDataSource\" matSort>\n\n    <ng-container matColumnDef=\"id\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> ID </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.id}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"name\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Name </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.name}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"country\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Country </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.country}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"city\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> City </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.city}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"type\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Type </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.type}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"category\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Category </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.category}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"capacity\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Capacity </th>\n      <td mat-cell *matCellDef=\"let row\"> {{row.capacity}} </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"manage\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Editing </th>\n      <td mat-cell *matCellDef=\"let row\" class=\"cursor\"> <mat-icon id=\"{{row.id}}\" mat-list-icon [routerLink]=\"[row.id]\">edit</mat-icon> </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"remove\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Remove </th>\n      <td mat-cell *matCellDef=\"let row; let i = index\" class=\"cursor\"> <mat-icon id=\"{{row.id}}\" mat-list-icon (click)=\"onRemove(row.id, i)\">delete</mat-icon> </td>\n    </ng-container>\n\n    <ng-container matColumnDef=\"comments\">\n      <th mat-header-cell *matHeaderCellDef mat-sort-header> Comments </th>\n      <td class=\"cursor\" mat-cell *matCellDef=\"let row\"><mat-icon id=\"{{row.id}}\" mat-list-icon (click)=\"onOpenDialog(row.id)\">comment</mat-icon></td>\n    </ng-container>\n\n    <tr mat-header-row *matHeaderRowDef=\"myDisplayedColumns\"></tr>\n    <tr mat-row *matRowDef=\"let row; columns: myDisplayedColumns;\">\n    </tr>\n  </table>\n\n  <mat-paginator [pageSizeOptions]=\"[5, 10, 25, 100]\"></mat-paginator>\n</div>\n"

/***/ }),

/***/ "./src/app/accomodations/accomodations.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/accomodations/accomodations.component.ts ***!
  \**********************************************************/
/*! exports provided: AccomodationsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AccomodationsComponent", function() { return AccomodationsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_comment_dialog_comment_dialog_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/comment-dialog/comment-dialog.component */ "./src/app/comment-dialog/comment-dialog.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AccomodationsComponent = /** @class */ (function () {
    function AccomodationsComponent(http, router, dialog) {
        this.http = http;
        this.router = router;
        this.dialog = dialog;
        this.myDisplayedColumns = ['id', 'name', 'country', 'city', 'type', 'category', 'capacity', 'manage', 'remove', 'comments'];
    }
    AccomodationsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.http.get('http://localhost:8081/accomodations').subscribe(function (data) {
            _this.accomodations = data;
            var accomodationsD = [];
            for (var i = 0; i < _this.accomodations.length; i++) {
                accomodationsD.push(createAccomodation(_this.accomodations[i]));
            }
            _this.myDataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](accomodationsD);
            _this.myDataSource.paginator = _this.paginator;
            _this.myDataSource.sort = _this.sort;
        });
    };
    AccomodationsComponent.prototype.applyFilter = function (filterValue) {
        filterValue = filterValue.trim(); // Remove whitespace
        filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
        this.myDataSource.filter = filterValue;
        if (this.myDataSource.paginator) {
            this.myDataSource.paginator.firstPage();
        }
    };
    AccomodationsComponent.prototype.onRemove = function (id, i) {
        var _this = this;
        this.http.delete('http://localhost:8081/accomodations/' + id, { responseType: 'text' }).subscribe(function (data) {
            _this.http.get('http://localhost:8081/accomodations').subscribe(function (data) {
                _this.accomodations = data;
                var accomodationsD = [];
                for (var i_1 = 0; i_1 < _this.accomodations.length; i_1++) {
                    accomodationsD.push(createAccomodation(_this.accomodations[i_1]));
                }
                _this.myDataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](accomodationsD);
            });
        });
    };
    AccomodationsComponent.prototype.onOpenDialog = function (id) {
        var dialogRef = this.dialog.open(src_app_comment_dialog_comment_dialog_component__WEBPACK_IMPORTED_MODULE_4__["CommentDialogComponent"], {
            width: '750px',
            data: id
        });
        dialogRef.afterClosed().subscribe(function (result) {
            if (result) {
            }
        });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"])
    ], AccomodationsComponent.prototype, "paginator", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSort"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSort"])
    ], AccomodationsComponent.prototype, "sort", void 0);
    AccomodationsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-accomodations',
            template: __webpack_require__(/*! ./accomodations.component.html */ "./src/app/accomodations/accomodations.component.html"),
            styles: [__webpack_require__(/*! ./accomodations.component.css */ "./src/app/accomodations/accomodations.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialog"]])
    ], AccomodationsComponent);
    return AccomodationsComponent;
}());

function createAccomodation(acc) {
    return {
        id: acc.id,
        name: acc.name,
        country: acc.country,
        city: acc.city,
        type: acc.accomodationType.type,
        category: acc.category.category,
        capacity: acc.capacity
    };
}


/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var src_app_accomodations_accomodations_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! src/app/accomodations/accomodations.component */ "./src/app/accomodations/accomodations.component.ts");
/* harmony import */ var src_app_new_accomodation_new_accomodation_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/new-accomodation/new-accomodation.component */ "./src/app/new-accomodation/new-accomodation.component.ts");
/* harmony import */ var src_app_accomodation_accomodation_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/accomodation/accomodation.component */ "./src/app/accomodation/accomodation.component.ts");
/* harmony import */ var src_app_terms_terms_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! src/app/terms/terms.component */ "./src/app/terms/terms.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};






var routes = [
    { path: '', redirectTo: 'accomodations', pathMatch: 'full' },
    { path: 'accomodations', component: src_app_accomodations_accomodations_component__WEBPACK_IMPORTED_MODULE_2__["AccomodationsComponent"], pathMatch: 'full' },
    { path: 'newaccomodation', component: src_app_new_accomodation_new_accomodation_component__WEBPACK_IMPORTED_MODULE_3__["NewAccomodationComponent"], pathMatch: 'full' },
    { path: 'accomodations/:id', component: src_app_accomodation_accomodation_component__WEBPACK_IMPORTED_MODULE_4__["AccomodationComponent"], pathMatch: 'full' },
    { path: 'terms', component: src_app_terms_terms_component__WEBPACK_IMPORTED_MODULE_5__["TermsComponent"], pathMatch: 'full' }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes, { useHash: true })
            ],
            exports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
            ]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-navbar></app-navbar>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var src_app_app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./navbar/navbar.component */ "./src/app/navbar/navbar.component.ts");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var src_app_modules_material_material_module__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! src/app/modules/material/material.module */ "./src/app/modules/material/material.module.ts");
/* harmony import */ var _new_accomodation_new_accomodation_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./new-accomodation/new-accomodation.component */ "./src/app/new-accomodation/new-accomodation.component.ts");
/* harmony import */ var _accomodations_accomodations_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./accomodations/accomodations.component */ "./src/app/accomodations/accomodations.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _accomodation_accomodation_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./accomodation/accomodation.component */ "./src/app/accomodation/accomodation.component.ts");
/* harmony import */ var _terms_terms_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./terms/terms.component */ "./src/app/terms/terms.component.ts");
/* harmony import */ var _messages_dialog_messages_dialog_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./messages-dialog/messages-dialog.component */ "./src/app/messages-dialog/messages-dialog.component.ts");
/* harmony import */ var _comment_dialog_comment_dialog_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./comment-dialog/comment-dialog.component */ "./src/app/comment-dialog/comment-dialog.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _navbar_navbar_component__WEBPACK_IMPORTED_MODULE_5__["NavbarComponent"],
                _new_accomodation_new_accomodation_component__WEBPACK_IMPORTED_MODULE_9__["NewAccomodationComponent"],
                _accomodations_accomodations_component__WEBPACK_IMPORTED_MODULE_10__["AccomodationsComponent"],
                _accomodation_accomodation_component__WEBPACK_IMPORTED_MODULE_12__["AccomodationComponent"],
                _terms_terms_component__WEBPACK_IMPORTED_MODULE_13__["TermsComponent"],
                _messages_dialog_messages_dialog_component__WEBPACK_IMPORTED_MODULE_14__["MessagesDialogComponent"],
                _comment_dialog_comment_dialog_component__WEBPACK_IMPORTED_MODULE_15__["CommentDialogComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_6__["BrowserAnimationsModule"],
                src_app_modules_material_material_module__WEBPACK_IMPORTED_MODULE_8__["MaterialModule"],
                src_app_app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_7__["ReactiveFormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClientModule"]
            ],
            entryComponents: [
                _messages_dialog_messages_dialog_component__WEBPACK_IMPORTED_MODULE_14__["MessagesDialogComponent"],
                _comment_dialog_comment_dialog_component__WEBPACK_IMPORTED_MODULE_15__["CommentDialogComponent"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/comment-dialog/comment-dialog.component.css":
/*!*************************************************************!*\
  !*** ./src/app/comment-dialog/comment-dialog.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-container {\r\n    display: flex;\r\n    flex-direction: column;\r\n  }\r\n  \r\n  .example-container > * {\r\n    width: 100%;\r\n  }\r\n  \r\n  mat-card{\r\n    background-color: rgb(233, 170, 94);\r\n  }\r\n  \r\n  mat-card-content{\r\n    border-radius: 25px;\r\n    padding: 10px;\r\n    border: 1px solid black;\r\n  }"

/***/ }),

/***/ "./src/app/comment-dialog/comment-dialog.component.html":
/*!**************************************************************!*\
  !*** ./src/app/comment-dialog/comment-dialog.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h2 mat-dialog-title>Comments</h2>\n\n<mat-dialog-content>\n  <div *ngFor = \"let comment of comments\">\n    <mat-card>\n      <mat-card-title>Rated {{comment.accomodation}}: {{comment.rating}}/10</mat-card-title>\n      <mat-card-subtitle>From: {{comment.username}}</mat-card-subtitle>\n      <mat-card-content>{{comment.comment}}</mat-card-content>\n    </mat-card>\n    <br>\n  </div>\n</mat-dialog-content>\n\n<mat-dialog-actions>\n  <button mat-dialog-close mat-raised-button color=\"primary\">Exit</button>\n</mat-dialog-actions>\n"

/***/ }),

/***/ "./src/app/comment-dialog/comment-dialog.component.ts":
/*!************************************************************!*\
  !*** ./src/app/comment-dialog/comment-dialog.component.ts ***!
  \************************************************************/
/*! exports provided: CommentDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommentDialogComponent", function() { return CommentDialogComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};




var CommentDialogComponent = /** @class */ (function () {
    function CommentDialogComponent(http, data) {
        this.http = http;
        this.data = data;
    }
    CommentDialogComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.http.get('http://localhost:8081/accomodations/' + this.data + '/comments').subscribe(function (data) {
            _this.comments = data;
        });
    };
    CommentDialogComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-comment-dialog',
            template: __webpack_require__(/*! ./comment-dialog.component.html */ "./src/app/comment-dialog/comment-dialog.component.html"),
            styles: [__webpack_require__(/*! ./comment-dialog.component.css */ "./src/app/comment-dialog/comment-dialog.component.css")]
        }),
        __param(1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_2__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"], Number])
    ], CommentDialogComponent);
    return CommentDialogComponent;
}());



/***/ }),

/***/ "./src/app/messages-dialog/messages-dialog.component.css":
/*!***************************************************************!*\
  !*** ./src/app/messages-dialog/messages-dialog.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-container {\r\n    display: flex;\r\n    flex-direction: column;\r\n  }\r\n  \r\n  .example-container > * {\r\n    width: 100%;\r\n  }"

/***/ }),

/***/ "./src/app/messages-dialog/messages-dialog.component.html":
/*!****************************************************************!*\
  !*** ./src/app/messages-dialog/messages-dialog.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h2 mat-dialog-title>Messages from {{user}}</h2>\n\n<mat-dialog-content>\n  <mat-chip-list class=\"mat-chip-list-stacked\">\n    <mat-chip *ngFor=\"let message of messages\" selected=\"true\" [color]=\"message.color\">\n      {{message.message}}\n    </mat-chip>\n  </mat-chip-list>\n  <br>\n  <br>\n  <div [formGroup]=\"form\" class=\"example-container\">\n    <mat-form-field>\n      <input matInput placeholder=\"Message content\" formControlName=\"message\">\n      <mat-error>Invalid message</mat-error>\n    </mat-form-field>\n  </div>\n</mat-dialog-content>\n\n<mat-dialog-actions>\n  <button [disabled]=\"!form.valid\"  mat-raised-button color=\"primary\" (click)=\"onSendMessage()\" >Send message</button>\n  <button mat-dialog-close mat-raised-button color=\"primary\">Exit</button>\n</mat-dialog-actions>\n"

/***/ }),

/***/ "./src/app/messages-dialog/messages-dialog.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/messages-dialog/messages-dialog.component.ts ***!
  \**************************************************************/
/*! exports provided: MessagesDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessagesDialogComponent", function() { return MessagesDialogComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (undefined && undefined.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};




var MessagesDialogComponent = /** @class */ (function () {
    function MessagesDialogComponent(fb, http, data) {
        this.fb = fb;
        this.http = http;
        this.data = data;
        this.user = "no user";
    }
    MessagesDialogComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.form = this.fb.group({
            message: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]]
        });
        this.http.get('http://localhost:8081/accomodations/terms/' + this.data).subscribe(function (data) {
            _this.term = data;
            _this.http.get('http://localhost:8081/accomodations/messages/' + _this.data).subscribe(function (data) {
                _this.messages = data;
                //if(this.messages.length != 0){
                _this.user = _this.term.user.email;
                _this.form.addControl("termId", new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](_this.term.id));
                _this.form.addControl("userId", new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](_this.term.user.id));
                //}
                for (var i = 0; i < _this.messages.length; i++) {
                    if (_this.messages[i].user != null) {
                        _this.messages[i].color = 'primary';
                    }
                    else {
                        _this.messages[i].color = 'warn';
                    }
                }
            });
        });
    };
    MessagesDialogComponent.prototype.onSendMessage = function () {
        var _this = this;
        this.http.post('http://localhost:8081/accomodations/messages', this.form.value).subscribe(function (data) {
            _this.messages.push(data);
            for (var i = 0; i < _this.messages.length; i++) {
                if (_this.messages[i].user != null) {
                    _this.messages[i].color = 'primary';
                }
                else {
                    _this.messages[i].color = 'warn';
                }
            }
        });
    };
    MessagesDialogComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-messages-dialog',
            template: __webpack_require__(/*! ./messages-dialog.component.html */ "./src/app/messages-dialog/messages-dialog.component.html"),
            styles: [__webpack_require__(/*! ./messages-dialog.component.css */ "./src/app/messages-dialog/messages-dialog.component.css")]
        }),
        __param(2, Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"])(_angular_material__WEBPACK_IMPORTED_MODULE_3__["MAT_DIALOG_DATA"])),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"], _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], Number])
    ], MessagesDialogComponent);
    return MessagesDialogComponent;
}());



/***/ }),

/***/ "./src/app/modules/material/material.module.ts":
/*!*****************************************************!*\
  !*** ./src/app/modules/material/material.module.ts ***!
  \*****************************************************/
/*! exports provided: MaterialModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MaterialModule", function() { return MaterialModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};



var MaterialModule = /** @class */ (function () {
    function MaterialModule() {
    }
    MaterialModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["LayoutModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCardModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatChipsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDatepickerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatNativeDateModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSelectModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginatorModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSortModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableModule"]
            ],
            exports: [
                _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["LayoutModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatButtonModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatListModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatFormFieldModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatInputModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCardModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatChipsModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDialogModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatDatepickerModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatNativeDateModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatCheckboxModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSelectModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatPaginatorModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSortModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatTableModule"]
            ]
        })
    ], MaterialModule);
    return MaterialModule;
}());



/***/ }),

/***/ "./src/app/navbar/navbar.component.css":
/*!*********************************************!*\
  !*** ./src/app/navbar/navbar.component.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".sidenav-container {\n    height: 100%;\n  }\n  \n  .sidenav {\n    width: 200px;\n    box-shadow: 3px 0 6px rgba(0,0,0,.24);\n  }\n  "

/***/ }),

/***/ "./src/app/navbar/navbar.component.html":
/*!**********************************************!*\
  !*** ./src/app/navbar/navbar.component.html ***!
  \**********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-sidenav-container class=\"sidenav-container\">\n  <mat-sidenav\n    #drawer\n    class=\"sidenav\"\n    fixedInViewport=\"true\"\n    [attr.role]=\"isHandset ? 'dialog' : 'navigation'\"\n    [mode]=\"(isHandset | async)!.matches ? 'over' : 'side'\"\n    [opened]=\"!(isHandset | async)!.matches\">\n\n    <mat-toolbar color=\"warn\">Menu</mat-toolbar>\n\n    <mat-nav-list>\n      <mat-list-item routerLink=\"/accomodations\">\n        <mat-icon mat-list-icon>home</mat-icon>\n        <p matLine>Accomodations</p>\n      </mat-list-item>\n      <mat-list-item routerLink=\"/newaccomodation\">\n        <mat-icon mat-list-icon>input</mat-icon>\n        <p matLine>Add accomodation</p>\n      </mat-list-item>\n      <mat-list-item routerLink=\"/terms\">\n        <mat-icon mat-list-icon>menu</mat-icon>\n        <p matLine>Manage reservations</p>\n      </mat-list-item>\n      <mat-list-item (click)=\"onSync()\">\n        <mat-icon mat-list-icon>sync</mat-icon>\n        <p matLine>Sync data</p>\n      </mat-list-item>\n    </mat-nav-list>\n  </mat-sidenav>\n\n  <mat-sidenav-content style=\"background: rgb(249, 249, 250);\">\n    <mat-toolbar color=\"warn\">\n      <button\n        type=\"button\"\n        aria-label=\"Toggle sidenav\"\n        mat-icon-button\n        (click)=\"drawer.toggle()\"\n        *ngIf=\"(isHandset | async)!.matches\">\n        <mat-icon aria-label=\"Side nav toggle icon\">menu</mat-icon>\n      </button>\n      <span>Agent application</span>\n    </mat-toolbar>\n    <router-outlet></router-outlet>\n  </mat-sidenav-content>\n</mat-sidenav-container>\n\n"

/***/ }),

/***/ "./src/app/navbar/navbar.component.ts":
/*!********************************************!*\
  !*** ./src/app/navbar/navbar.component.ts ***!
  \********************************************/
/*! exports provided: NavbarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NavbarComponent", function() { return NavbarComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var NavbarComponent = /** @class */ (function () {
    function NavbarComponent(breakpointObserver, http, snackBar) {
        this.breakpointObserver = breakpointObserver;
        this.http = http;
        this.snackBar = snackBar;
        this.isHandset = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["Breakpoints"].Handset);
    }
    NavbarComponent.prototype.ngOnInit = function () {
    };
    NavbarComponent.prototype.onSync = function () {
        var _this = this;
        this.http.get('http://localhost:8081/accomodations/sync').subscribe(function () {
            _this.snackBar.open('Data synced with server', 'Close', {
                duration: 2000
            });
            window.location.reload();
        });
    };
    NavbarComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-navbar',
            template: __webpack_require__(/*! ./navbar.component.html */ "./src/app/navbar/navbar.component.html"),
            styles: [__webpack_require__(/*! ./navbar.component.css */ "./src/app/navbar/navbar.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["BreakpointObserver"], _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], _angular_material__WEBPACK_IMPORTED_MODULE_3__["MatSnackBar"]])
    ], NavbarComponent);
    return NavbarComponent;
}());



/***/ }),

/***/ "./src/app/new-accomodation/new-accomodation.component.css":
/*!*****************************************************************!*\
  !*** ./src/app/new-accomodation/new-accomodation.component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-container {\r\n    display: flex;\r\n    flex-direction: column;\r\n  }\r\n  \r\n  .example-container > * {\r\n    width: 100%;\r\n  }\r\n  \r\n  .example-card {\r\n    max-width: 1000px;\r\n    margin: 20px auto;\r\n  }\r\n  \r\n  .mat-raised-button{\r\n    background-color: coral;\r\n  }\r\n  \r\n  mat-divider{\r\n    background-color:brown;\r\n  }\r\n  \r\n  .term{\r\n    padding: 10px;\r\n  }"

/***/ }),

/***/ "./src/app/new-accomodation/new-accomodation.component.html":
/*!******************************************************************!*\
  !*** ./src/app/new-accomodation/new-accomodation.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"example-card\">\n  <mat-card-content>\n    <form [formGroup]=\"form\" (ngSubmit)=\"onSubmit()\" style=\"margin-bottom: 20px\">\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter accomodation name\" formControlName=\"name\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter Country\" formControlName=\"country\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter City\" formControlName=\"city\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"text\" matInput placeholder=\"Enter Address\" formControlName=\"address\">\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n          <mat-form-field>\n              <mat-select placeholder=\"Choose your accomodation type\" formControlName=\"accomodationType\">\n                <mat-option *ngFor=\"let type of types\" [value]=\"type.id\">\n                  {{ type.type }}\n                </mat-option>\n              </mat-select>\n            </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n            <mat-select placeholder=\"Choose your accomodation category\" formControlName=\"category\">\n              <mat-option *ngFor=\"let category of categories\" [value]=\"category.id\">\n                {{ category.category }}\n              </mat-option>\n            </mat-select>\n          </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <textarea matInput placeholder=\"Description\" formControlName=\"description\"></textarea>\n        </mat-form-field>\n      </div>\n      <div class=\"example-container\">\n        <mat-form-field>\n          <input type=\"number\" matInput placeholder=\"Capacity\" formControlName=\"capacity\">\n        </mat-form-field>\n      </div>\n      <br><br>\n      <mat-divider></mat-divider>\n      <div formArrayName=\"terms\">\n        <h4>Your terms</h4>\n        <button mat-raised-button type=\"button\"\n        (click)=\"onAddTerm()\" [disabled]=\"!form.get('terms').valid\">Add term</button>\n        <div class=\"form-group\"\n        *ngFor=\"let termControl of form.get('terms').controls; let i = index\">\n          <div [formGroupName]=\"i\">\n            <mat-form-field class=\"term\">\n              <input  matInput [matDatepicker]=\"pickerFrom\" placeholder=\"From\" class=\"form-control\" formControlName=\"startDate\">\n              <mat-datepicker-toggle matSuffix [for]=\"pickerFrom\"></mat-datepicker-toggle>\n              <mat-datepicker #pickerFrom></mat-datepicker>\n            </mat-form-field>\n            <mat-form-field class=\"term\">\n              <input  matInput [matDatepicker]=\"pickerTo\" placeholder=\"To\" class=\"form-control\" formControlName=\"endDate\">\n              <mat-datepicker-toggle matSuffix [for]=\"pickerTo\"></mat-datepicker-toggle>\n              <mat-datepicker #pickerTo></mat-datepicker>\n            </mat-form-field >\n            <mat-form-field class=\"term\">\n                <input type=\"number\" matInput placeholder=\"Price\" class=\"form-control\" formControlName=\"price\">\n            </mat-form-field>\n            <mat-form-field class=\"term\" color=\"warn\" appearance=\"outline\">\n              <mat-chip-list>\n\n                <mat-chip class=\"form-control\" color=\"warn\" selected=\"true\" (click)=\"onTermRemove(termControl,$event)\">Remove</mat-chip>\n\n              </mat-chip-list>\n            </mat-form-field>\n          </div>\n        </div>\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <div formArrayName=\"additionalServices\">\n        <h4>Your additional services</h4>\n        <div *ngFor=\"let service of services\">\n\n            <mat-checkbox (change)=\"onServiceCheck(service.id, $event)\">{{service.name}}</mat-checkbox>\n\n        </div>\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <div>\n        <h4>Your images:</h4>\n        <input type=\"file\" multiple accept=\"image/*\" placeholder=\"Upload images\" (change)=\"onFileChanged($event)\">\n      </div>\n      <br>\n      <mat-divider></mat-divider>\n      <br>\n      <button mat-raised-button color=\"warn\" type=\"submit\" [disabled]=\"!form.valid\">Add</button>\n    </form>\n\n  </mat-card-content>\n\n\n</mat-card>\n\n"

/***/ }),

/***/ "./src/app/new-accomodation/new-accomodation.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/new-accomodation/new-accomodation.component.ts ***!
  \****************************************************************/
/*! exports provided: NewAccomodationComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NewAccomodationComponent", function() { return NewAccomodationComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var NewAccomodationComponent = /** @class */ (function () {
    function NewAccomodationComponent(fb, snackBar, http, router) {
        this.fb = fb;
        this.snackBar = snackBar;
        this.http = http;
        this.router = router;
        this.services = [];
    }
    NewAccomodationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.form = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroup"]({
            'name': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'country': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'city': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'address': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'accomodationType': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'category': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'description': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null),
            'capacity': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'terms': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormArray"]([]),
            'additionalServices': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]([])
        });
        var group = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroup"]({
            'startDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'endDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'price': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
        });
        this.form.get('terms').push(group);
        this.http.get('http://localhost:8081/additionalServices').subscribe(function (data) {
            _this.services = data;
        });
        this.http.get('http://localhost:8081/accomodationTypes').subscribe(function (data) {
            _this.types = data;
        });
        this.http.get('http://localhost:8081/categories').subscribe(function (data) {
            _this.categories = data;
        });
    };
    NewAccomodationComponent.prototype.onAddTerm = function () {
        // const control = new FormControl(null,Validators.required);
        // (<FormArray>this.form.get('terms')).push(control);
        var group = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroup"]({
            'startDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'endDate': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
            'price': new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"](null, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required),
        });
        this.form.get('terms').push(group);
    };
    NewAccomodationComponent.prototype.onTermRemove = function (term, event) {
        if (this.form.get('terms').length > 1) {
            this.form.get('terms').removeAt(this.form.get('terms').value.indexOf(term.value));
        }
        else {
            this.snackBar.open('There must be at least 1 term!', 'Close', {
                duration: 2000
            });
        }
    };
    NewAccomodationComponent.prototype.onServiceCheck = function (id, event) {
        var niz = this.form.get('additionalServices').value;
        if (event.checked) {
            niz.push(id);
        }
        else {
            var index = niz.indexOf(id);
            niz.splice(index, 1);
        }
    };
    NewAccomodationComponent.prototype.onSubmit = function () {
        var _this = this;
        if (this.form.valid && this.images != null) {
            this.http.post('http://localhost:8081/accomodations', this.form.value)
                .subscribe(function (data) {
                var id = data.id;
                var formData = new FormData();
                for (var _i = 0, _a = _this.images; _i < _a.length; _i++) {
                    var image = _a[_i];
                    formData.append('image', image, image.name);
                }
                _this.http.post('http://localhost:8081/accomodations/' + id, formData)
                    .subscribe(function () {
                    _this.snackBar.open('Adding accomodation and uploading images, please wait.', 'Close', {
                        duration: 2000
                    });
                    _this.router.navigate(['']);
                });
            });
        }
        else {
            this.snackBar.open('You must add atleast 1 picture!', 'Close', {
                duration: 2000
            });
        }
    };
    NewAccomodationComponent.prototype.onFileChanged = function (event) {
        this.images = event.target.files;
    };
    NewAccomodationComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-new-accomodation',
            template: __webpack_require__(/*! ./new-accomodation.component.html */ "./src/app/new-accomodation/new-accomodation.component.html"),
            styles: [__webpack_require__(/*! ./new-accomodation.component.css */ "./src/app/new-accomodation/new-accomodation.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"],
            _angular_material__WEBPACK_IMPORTED_MODULE_2__["MatSnackBar"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"],
            _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]])
    ], NewAccomodationComponent);
    return NewAccomodationComponent;
}());



/***/ }),

/***/ "./src/app/terms/terms.component.css":
/*!*******************************************!*\
  !*** ./src/app/terms/terms.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "table {\r\n    width: 100%;\r\n    padding: 20px;\r\n  }\r\n  \r\n  .mat-form-field {\r\n    font-size: 14px;\r\n    width: 80%;\r\n    padding: 20px;\r\n  }\r\n  \r\n  .cursor{\r\n    cursor: pointer;\r\n  }"

/***/ }),

/***/ "./src/app/terms/terms.component.html":
/*!********************************************!*\
  !*** ./src/app/terms/terms.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-form-field>\n    <input matInput (keyup)=\"applyFilter($event.target.value)\" placeholder=\"Filter\">\n  </mat-form-field>\n  \n  <div class=\"mat-elevation-z8\">\n    <table mat-table [dataSource]=\"myDataSource\" matSort>\n  \n      <ng-container matColumnDef=\"id\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> ID </th>\n        <td mat-cell *matCellDef=\"let row\"> {{row.id}} </td>\n      </ng-container>\n  \n      <ng-container matColumnDef=\"accomodation_name\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Accomodation name </th>\n        <td mat-cell *matCellDef=\"let row\"> {{row.accomodation_name}} </td>\n      </ng-container>\n  \n      <ng-container matColumnDef=\"start_date\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Start date </th>\n        <td mat-cell *matCellDef=\"let row\"> {{row.start_date}} </td>\n      </ng-container>\n  \n      <ng-container matColumnDef=\"end_date\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> End date </th>\n        <td mat-cell *matCellDef=\"let row\"> {{row.end_date}} </td>\n      </ng-container>\n  \n      <ng-container matColumnDef=\"price\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Price </th>\n        <td mat-cell *matCellDef=\"let row\"> {{row.price}} </td>\n      </ng-container>\n  \n      <ng-container matColumnDef=\"visited\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Visited </th>\n        <td mat-cell *matCellDef=\"let row; let i=index\"><mat-checkbox [checked]=\"row.visited\" (change)=\"onVisitedCheck(row.id, $event, i)\"></mat-checkbox></td>\n      </ng-container>\n\n      <ng-container matColumnDef=\"reserved\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Reserved </th>\n        <td mat-cell *matCellDef=\"let row ; let i = index\"><mat-checkbox [disabled]=\"row.reserved\" [checked]=\"row.reserved\" (change)=\"onReservedCheck(row.id, $event, i)\"></mat-checkbox></td>\n      </ng-container>\n\n      <ng-container matColumnDef=\"inbox\">\n        <th mat-header-cell *matHeaderCellDef mat-sort-header> Inbox </th>\n        <td class=\"cursor\" mat-cell *matCellDef=\"let row; let i = index\"><mat-icon id=\"{{row.id}}\" mat-list-icon (click)=\"onOpenDialog(row.id, i)\">inbox</mat-icon></td>\n      </ng-container>\n  \n      <tr mat-header-row *matHeaderRowDef=\"myDisplayedColumns\"></tr>\n      <tr mat-row *matRowDef=\"let row; columns: myDisplayedColumns;\">\n      </tr>\n    </table>\n  \n    <mat-paginator [pageSizeOptions]=\"[5, 10, 25, 100]\"></mat-paginator>\n  </div>\n  "

/***/ }),

/***/ "./src/app/terms/terms.component.ts":
/*!******************************************!*\
  !*** ./src/app/terms/terms.component.ts ***!
  \******************************************/
/*! exports provided: TermsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TermsComponent", function() { return TermsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var src_app_messages_dialog_messages_dialog_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/messages-dialog/messages-dialog.component */ "./src/app/messages-dialog/messages-dialog.component.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var TermsComponent = /** @class */ (function () {
    function TermsComponent(http, dialog, snackBar) {
        this.http = http;
        this.dialog = dialog;
        this.snackBar = snackBar;
        this.myDisplayedColumns = ['id', 'accomodation_name', 'start_date', 'end_date', 'price', 'visited', 'reserved', 'inbox'];
    }
    TermsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.http.get('http://localhost:8081/accomodations/visited').subscribe(function (data) {
            _this.terms = data;
            var termsD = [];
            for (var i = 0; i < _this.terms.length; i++) {
                termsD.push(createTerm(_this.terms[i]));
            }
            console.log(termsD);
            _this.myDataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](termsD);
            _this.myDataSource.paginator = _this.paginator;
            _this.myDataSource.sort = _this.sort;
        });
    };
    TermsComponent.prototype.applyFilter = function (filterValue) {
        filterValue = filterValue.trim(); // Remove whitespace
        filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
        this.myDataSource.filter = filterValue;
        if (this.myDataSource.paginator) {
            this.myDataSource.paginator.firstPage();
        }
    };
    TermsComponent.prototype.onOpenDialog = function (id, i) {
        if (this.terms[i].user != null) {
            var dialogRef = this.dialog.open(src_app_messages_dialog_messages_dialog_component__WEBPACK_IMPORTED_MODULE_3__["MessagesDialogComponent"], {
                width: '450px',
                data: id
            });
            dialogRef.afterClosed().subscribe(function (result) {
                if (result) {
                }
            });
        }
        else {
            this.snackBar.open('This term has not been reserved!', 'Close', {
                duration: 3000
            });
        }
    };
    TermsComponent.prototype.onVisitedCheck = function (id, event, i) {
        var _this = this;
        if (this.terms[i].reserved) {
            this.http.get('http://localhost:8081/accomodations/' + id + '/' + event.checked, { responseType: 'text' }).subscribe(function (data) {
                _this.terms[i].visited = event.checked;
                var termsD = [];
                for (var i_1 = 0; i_1 < _this.terms.length; i_1++) {
                    termsD.push(createTerm(_this.terms[i_1]));
                }
                _this.myDataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](termsD);
                _this.myDataSource.paginator = _this.paginator;
                _this.myDataSource.sort = _this.sort;
            });
        }
        else {
            this.snackBar.open('You cannot set a term to visited if it has not been reserved', 'Close', {
                duration: 3000
            });
            this.terms[i].visited = false;
        }
    };
    TermsComponent.prototype.onReservedCheck = function (id, event, i) {
        var _this = this;
        this.http.get('http://localhost:8081/accomodations/terms/' + id + '/reserved/' + event.checked, { responseType: 'text' }).subscribe(function (data) {
            _this.terms[i].reserved = event.checked;
            var termsD = [];
            for (var i_2 = 0; i_2 < _this.terms.length; i_2++) {
                termsD.push(createTerm(_this.terms[i_2]));
            }
            _this.myDataSource = new _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatTableDataSource"](termsD);
            _this.myDataSource.paginator = _this.paginator;
            _this.myDataSource.sort = _this.sort;
        }, function (error) {
            _this.snackBar.open('Error reserving a term, Term is already reserved by a user!!!', 'Close', {
                duration: 4000
            });
            _this.terms[i].reserved = true;
        });
    };
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatPaginator"])
    ], TermsComponent.prototype, "paginator", void 0);
    __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"])(_angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSort"]),
        __metadata("design:type", _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSort"])
    ], TermsComponent.prototype, "sort", void 0);
    TermsComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-terms',
            template: __webpack_require__(/*! ./terms.component.html */ "./src/app/terms/terms.component.html"),
            styles: [__webpack_require__(/*! ./terms.component.css */ "./src/app/terms/terms.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatDialog"], _angular_material__WEBPACK_IMPORTED_MODULE_1__["MatSnackBar"]])
    ], TermsComponent);
    return TermsComponent;
}());

function createTerm(term) {
    return {
        id: term.id,
        accomodation_name: term.accomodation.name,
        start_date: term.startDate,
        end_date: term.endDate,
        price: term.price,
        visited: term.visited,
        reserved: term.reserved
    };
}


/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\Boris Hadzic\git\XWS-Project\AgentFront\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map