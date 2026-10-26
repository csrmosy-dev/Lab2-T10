package edu.iau.cshj.csc402.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseListScreen()
                }
            }
        }
    }
}

data class CourseModel(val code: String, val title: String, val credits: Int)

@Composable
fun CourseListScreen(modifier: Modifier = Modifier) {
    val courses = remember {
        listOf(
            CourseModel("CSC 402", "Mobile Application Programming", 3),
            CourseModel("CSC 311", "Database Systems", 4),
            CourseModel("CSC 340", "Operating Systems", 3),
            CourseModel("MATH 202", "Discrete Mathematics", 3),
            CourseModel("ENG 214", "Technical Writing", 2),
            CourseModel("PHYS 105", "General Physics II", 4),
            CourseModel("ISLM 101", "Islamic Culture", 2)
        )
    }

    val navy = Color(0xFF0B2545)
    val androidGreen = Color(0xFF3DDC84)
    val screenBackground = Color(0xFFF4F7FA)
    val cardWhite = Color(0xFFFFFFFF)
    val textGrey = Color(0xFF6B7A8F)
    val chipGreyBg = Color(0xFFE6ECF4)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(screenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(navy)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(text = "CSC 402 Lab 2", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Task 10 - My Courses (LazyColumn)", color = Color(0xFFB8C4D6), fontSize = 12.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(androidGreen)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = cardWhite),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text(
                                text = course.code,
                                color = navy,
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = course.title,
                                color = textGrey,
                                fontSize = 14.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Box(
                            modifier = Modifier
                                .background(chipGreyBg, shape = RoundedCornerShape(50))
                                .padding(horizontal = 12.dp, vertical = 5.dp)
                        ) {
                            Text(
                                text = "${course.credits} CR",
                                color = navy,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}