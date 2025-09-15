package com.colodin.mvicompose.product.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.RatingBar
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.colodin.mvicompose.R
import com.colodin.mvicompose.product.data.QAProductShort
import com.colodin.mvicompose.product.domain.ProductAction
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductView(productViewModel: ProductViewModel = koinViewModel(),onClickProduct:()-> Unit) {


    val productItems by productViewModel.mediatorProductItems.observeAsState(emptyList())
    val isCircularProgressIndicator by productViewModel.mediatorProductShowProgress.observeAsState(initial = false)
    val mediatorProductErrorMessage by productViewModel.mediatorProductErrorMessage.observeAsState()

    if (mediatorProductErrorMessage!=null) {
        Toast.makeText(LocalContext.current,mediatorProductErrorMessage,Toast.LENGTH_LONG).show()
        productViewModel.mediatorProductErrorMessage.postValue(null)
    }

    Box(Modifier.fillMaxSize()){
        ProductList(productItems) { item ->
            onClickProduct()
            productViewModel.dispatch(ProductAction.ProductActionFullProduct(item.id))
        }

        if (isCircularProgressIndicator) {
            CircularProgressIndicator(modifier = Modifier
                .align(Alignment.Center)
                .testTag("circularProgressIndicator"))
        }
    }
}


@Composable
fun ProductList(productItems: List<QAProductShort>, onClickProductShort: (QAProductShort) -> Unit) {
    LazyColumn {
        items(productItems) {
            ProductItem(it,Modifier ,onClickProductShort)
        }
    }
}

@SuppressLint("InflateParams")
@Composable
fun ProductItem(item: QAProductShort, modifier: Modifier = Modifier, onClickProductShort: (QAProductShort) -> Unit) {
    Row(modifier = modifier
        .testTag("ProductItem")
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
            onClickProductShort(item)
        }) {
        AsyncImage(
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(80.dp, 45.dp)
                .clip(RoundedCornerShape(8.dp)),
            model = item.thumbnail,
            contentDescription = item.title
        )
        Column(modifier = modifier.padding(start = 8.dp)) {
            Text(text = item.title, style = MaterialTheme.typography.titleMedium)
            Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = item.price, style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Light, color = MaterialTheme.colorScheme.onSurfaceVariant))
                AndroidView(
                    factory = { context ->
                        val view = LayoutInflater.from(context).inflate(R.layout.product_rating, null, false)
                        view
                    },
                    update = { counterView ->
                        val ratingBar = counterView.findViewById<RatingBar>(R.id.productShortRating)
                        ratingBar.rating = item.rating
                    }

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(item = QAProductShort(id = 1, title = "Product title", price = "$1", rating = 5f, thumbnail = "")) {

    }
}
