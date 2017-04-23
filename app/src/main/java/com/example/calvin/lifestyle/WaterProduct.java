package com.example.calvin.lifestyle;



public class WaterProduct {

    private int _id;
    private String _productName;
    private int _waterIntake;

    public WaterProduct(){

    }

    public WaterProduct(String productName) {
        this._productName = productName;
    }

    public WaterProduct(int waterIntake) {
        this._waterIntake = waterIntake;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public void set_waterIntake(int _waterIntake) {
        this._waterIntake = _waterIntake;
    }

    public String get_productName() {
        return _productName;
    }

    public int get_id() {
        return _id;
    }

    public int get_waterIntake() {
        return _waterIntake;
    }
}
