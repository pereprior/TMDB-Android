package com.example.movietest.ui.components.bar.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movietest.R
import com.example.movietest.ui.components.constants.LOW_PADDING_VALUE
import com.example.movietest.ui.components.constants.MEDIUM_PADDING_VALUE
import com.example.movietest.ui.components.constants.TOP_BAR_PADDING_VALUE
import com.example.movietest.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(darkTheme: MutableState<Boolean>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_BAR_PADDING_VALUE.dp)
    ) {
        TopAppBar(
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "App icon",
                    modifier = Modifier.padding(MEDIUM_PADDING_VALUE.dp)
                )
            },
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = typography.titleLarge
                )
            },
            actions = {
                Row (
                    modifier = Modifier
                        .padding(LOW_PADDING_VALUE.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_themes),
                        contentDescription = "themes icon"
                    )

                    Spacer(modifier = Modifier.padding(LOW_PADDING_VALUE.dp))

                    Switch(
                        checked = darkTheme.value,
                        onCheckedChange = { isChecked ->
                            darkTheme.value = isChecked
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorScheme.primary,
                            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        )
                    )
                }
            },
            colors = topAppBarColors(MaterialTheme.colorScheme.secondary),
            modifier = Modifier.fillMaxWidth()
        )
    }
}