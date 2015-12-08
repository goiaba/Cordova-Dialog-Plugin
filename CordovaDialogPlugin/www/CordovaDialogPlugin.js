var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "CordovaDialogPlugin", "coolMethod", [arg0]);
};

exports.alert = function(title, message, btnLabel, success, error) {
	exec(success, error, "CordovaDialogPlugin", "alert", [title, message, btnLabel]);
};

exports.confirm = function(title, message, btnLabelYes, btnLabelNo, success, error) {
	exec(success, error, "CordovaDialogPlugin", "confirm", [title, message, btnLabelYes, btnLabelNo]);
}