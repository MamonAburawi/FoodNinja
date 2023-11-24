package com.example.foodninja.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R


@Composable
fun Dialog(
    title: String,
    subTitle: String,
    textField: @Composable () -> Unit? = {},
    onConfirmClicked:() -> Unit = {},
    onDismissClicked:() -> Unit = {},
    onDismissRequest: () -> Unit = {}
) {

    AlertDialog(
        title = {
            TextLabelLarge(text = title)
        },
        text = {
            Column {
                TextLabelLarge(
                    text = subTitle,
                    fontSize = 14
                )
                SpacerHeight20()
                textField()
            }

        },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            SimpleButton(
                modifier = Modifier.width(100.dp),
                text = "Confirm"
            ) {
                onConfirmClicked()
            }

        },
        dismissButton = {
            SimpleButton(
                modifier = Modifier.width(100.dp),
                text = "Dismiss"
            ) {
                onDismissClicked()
            }
        },
    )


}

@Preview
@Composable
fun DialogPreview() {
    Dialog(
        title = stringResource(R.string.verify_info_dialog_title),
        subTitle = stringResource(R.string.verify_info_dialog_email_sub_title)
    )
}