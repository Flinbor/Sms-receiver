/*
 * Copyright 2016 Flinbor Aleksandr Bogdanov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package in.flinbor.demo.smsreceiver.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import in.flinbor.demo.smsreceiver.data.model.SMSObject;

/**
 * activity does not set a contentView and just pops the Dialogue
 * finish() the activity when the dialogue is dismissed
 */
public class NotificationDialogActivity extends Activity {
    public static final String SMS_BUNDLE = "smsBundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SMSObject smsObject = getIntent().getParcelableExtra(SMS_BUNDLE);
        new AlertDialog.Builder(this)
                .setTitle(smsObject.getSender())
                .setMessage(smsObject.getContent())
                .setIcon(android.R.drawable.ic_dialog_email)
                .setPositiveButton(getString(android.R.string.ok), null)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        NotificationDialogActivity.this.finish();
                    }
                }).create().show();
    }
}
