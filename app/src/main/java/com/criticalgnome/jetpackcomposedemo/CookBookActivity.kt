package com.criticalgnome.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.criticalgnome.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class CookBookActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Column {
                    RecipesList(recipes = CookBookRecipes.defaultRecipes)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun RecipesList(recipes: List<Recipe>) {
    LazyColumn {
        items(recipes) { RecipeCard(recipe = it) }
    }
}

@Composable
fun RecipeCard(recipe: Recipe) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(all = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = recipe.resId),
                contentDescription = "Image Preview",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            )
            Column(modifier = Modifier.padding(all = 16.dp)) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.h4
                )
                recipe.ingredients.forEach { ingredient ->
                    Text(text = "- ${ingredient.title}")
                }
            }
        }
    }
}

@Preview(
    name = "Recipe Card",
    showBackground = true
)
@Composable
fun PreviewRecipeCard() {
    RecipeCard(recipe = CookBookRecipes.defaultRecipes[0])
}

@Preview(
    name = "Recipe List",
    showBackground = true
)
@Composable
fun PreviewRecipeList() {
    JetpackComposeDemoTheme {
        RecipesList(recipes = CookBookRecipes.defaultRecipes)
        Spacer(modifier = Modifier.height(16.dp))
    }
}
