package com.artemissoftware.amphitriteui2.multipletheme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.R
import com.artemissoftware.amphitriteui2.ui.theme.AmphitriteUI2Theme
import com.artemissoftware.amphitriteui2.ui.theme.ThemeType

@Composable
fun BlueScreen(
    onClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colorScheme.primary),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onClick.invoke()
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_book),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                )
            }
        },
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            PaddingValues(8.dp)
            Text(
                text = "I am a blue theme",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp),
            )
            PaddingValues(8.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BlueScreenPreview() {
    AmphitriteUI2Theme(themeType = ThemeType.Blue) {
        BlueScreen(
            onClick = {},
        )
    }
}
