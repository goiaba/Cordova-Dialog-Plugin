package edu.luc.fall2015.comp422.CordovaDialogPlugin;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaDialogPlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("alert".equals(action)) {
            String title = args.getString(0);
            String message = args.getString(1);
            String btnLabel = args.getString(2);
            this.alert(title, message, btnLabel, callbackContext);
        } else if ("confirm".equals(action)) {
            String title = args.getString(0);
            String message = args.getString(1);
            String btnLabelYes = args.getString(2);
            String btnLabelNo = args.getString(3);
            this.confirm(title, message, btnLabelYes, btnLabelNo, callbackContext);
        } else {
            return false;
        }
        return true;
    }

    private void alert(final String title, final String message, final String btnLabel, final CallbackContext callbackContext) {
        new AlertDialog.Builder(cordova.getActivity())
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setNeutralButton(btnLabel, new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.dismiss();
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                }
            }).create().show();
    }

    private void confirm(final String title, final String message, final String btnLabelYes, final String btnLabelNo, final CallbackContext callbackContext) {
        new AlertDialog.Builder(cordova.getActivity())
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(btnLabelYes, new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int which) {
                    dialogInterface.dismiss();
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                }
            })
            .setNegativeButton(btnLabelNo, null)
            .create().show();
    }
}
