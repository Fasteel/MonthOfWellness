package com.example.monthofwellness

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.monthofwellness.data.repository.DayRepository

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier.padding(dimensionResource(R.dimen.big)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium))
    ) {
        itemsIndexed(DayRepository.data) { i, day ->
            DayCard(
                day = i + 1,
                title = day.title,
                image = day.image,
                description = day.description,
                modifier = Modifier
            )
        }
    }
}
