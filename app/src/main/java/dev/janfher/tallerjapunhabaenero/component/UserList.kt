import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.janfher.tallerjapunhabaenero.ItemComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserList(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = { Text("User List", color = Color.Black) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            val users = listOf(
                "Luis Perez" to Icons.Default.Edit,
                "Mario Cajas" to Icons.Default.Edit,
                "Fernando Arteaga" to Icons.Default.Edit,
                "Ribaldo Nantip" to Icons.Default.Bathtub,
                "Jostin Torres" to Icons.Default.Bathtub,
                "Domenica Torres" to Icons.Default.Bathtub
            )

            users.forEachIndexed { index, (name, icon) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (index < 3) Color.Green else Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(text = name, style = MaterialTheme.typography.bodyLarge)
                    }
                    IconButton(onClick = { navController.navigate("param/$name") }) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Call $name",
                            tint = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                OutlinedButton(
                    onClick = { navController.navigate("home") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Magenta
                    ),
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(0.5f)
                ) {
                    Text(text = "Regresar")
                }
            }
        }
    }
}