package com.example.monthofwellness

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.monthofwellness.ui.theme.MonthOfWellnessTheme

@Composable
fun DayCard(
    day: Int,
    @StringRes title: Int,
    @DrawableRes image: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    var expand by remember { mutableStateOf(false) }
    Card(modifier = modifier.clickable { expand = !expand }) {
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.small))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(text = "Day $day", style = MaterialTheme.typography.labelLarge)
            Text(text = stringResource(title), style = MaterialTheme.typography.titleLarge)
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(R.string.image),
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(R.dimen.small),
                        bottom = dimensionResource(R.dimen.small)
                    )
            )
            if (expand) {
                Text(
                    text = stringResource(description),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
@Preview
fun DayCardPreview() {
    MonthOfWellnessTheme {
        DayCard(1, R.string.day_1_title, R.drawable.day_1_image, R.string.day_1_description)
    }
}

@Composable
@Preview
fun DayCardPreviewDark() {
    MonthOfWellnessTheme(darkTheme = true) {
        DayCard(1, R.string.day_1_title, R.drawable.day_1_image, R.string.day_1_description)
    }
}
