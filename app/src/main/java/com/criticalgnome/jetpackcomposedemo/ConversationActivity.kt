package com.criticalgnome.jetpackcomposedemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.criticalgnome.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class ConversationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }
}

data class Message(
    val author: String,
    val body: String
)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { MessageCard(it) }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview(
    name = "Message Light Mode",
    showBackground = true
)
@Preview(
    name = "Message Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMessageCard() {
    JetpackComposeDemoTheme {
        MessageCard(
            message = Message(
                "Colleague",
                "Hey, take a look at Jetpack Compose, it's great!"
            )
        )
    }
}

@Preview(
    name = "Conversation",
    showBackground = true
)
@Composable
fun PreviewConversation() {
    JetpackComposeDemoTheme {
        Conversation(
            messages = SampleData.conversationSample
        )
    }
}
