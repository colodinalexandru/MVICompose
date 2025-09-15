package com.colodin.mvicompose.product.presentation


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.RatingBar
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.colodin.mvicompose.R
import com.colodin.mvicompose.product.data.QAProductFull
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductViewFullScreen(productViewModel: ProductViewModel = koinViewModel()) {

    val productFull by productViewModel.mediatorProductFull.observeAsState()

    val mediatorProductErrorMessage by productViewModel.mediatorProductErrorMessage.observeAsState()
    val isCircularProgressIndicator by productViewModel.mediatorProductShowProgress.observeAsState(initial = false)

    if (mediatorProductErrorMessage!=null) {
        Toast.makeText(LocalContext.current,mediatorProductErrorMessage, Toast.LENGTH_LONG).show()
        productViewModel.mediatorProductErrorMessage.postValue(null)
    } else {
        productFull?.let { ProductViewFull(it) } ?: run {
            if (isCircularProgressIndicator) {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .testTag("circularProgressIndicator")
                    )
                }
            }
        }
    }
}

@SuppressLint("InflateParams")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductViewFull(productFull: QAProductFull) {
    val scrollState = rememberScrollState()
    val pageState = rememberPagerState(pageCount = {
        productFull.images.size
    })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Text(text = productFull.title, style = MaterialTheme.typography.bodyLarge)

        HorizontalPager(
            state = pageState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.77f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(32.dp)),
                    model = productFull.images[page],
                    contentDescription = productFull.title
                )
            }
        }
        AndroidView(
            factory = { context ->
                val view = LayoutInflater.from(context).inflate(R.layout.product_rating_full, null, false)
                view
            },
            update = { counterView ->
                val ratingBar = counterView.findViewById<RatingBar>(R.id.productShortRating)
                ratingBar.rating = productFull.rating
            }

        )

        Row(
            horizontalArrangement = SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Column {
                Text(text = stringResource(id = R.string.full_price), style = MaterialTheme.typography.bodyLarge)
                Text(text = productFull.price, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onSurfaceVariant))
            }

            Column {
                Text(text = stringResource(id = R.string.full_category), style = MaterialTheme.typography.bodyLarge)
                Text(text = productFull.category, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onSurfaceVariant))
            }
        }

        Row(
            horizontalArrangement = SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Column {
                Text(text = stringResource(id = R.string.full_discount), style = MaterialTheme.typography.bodyLarge)
                Text(text = productFull.discountPercentage, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onSurfaceVariant))
            }

            Column {
                Text(text = stringResource(id = R.string.full_stock), style = MaterialTheme.typography.bodyLarge)
                Text(text = productFull.stock, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onSurfaceVariant))

            }
        }

        Text(
            text = productFull.description, style = MaterialTheme.typography.bodyLarge, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductViewFullPreview() {
    val productFull = QAProductFull(id = 1, title = "title", description = "description", price = "$1.00", discountPercentage = "1.00%", rating = 5.00f, stock = "10", category = "category", images = emptyList())
    ProductViewFull(productFull = productFull)
}
