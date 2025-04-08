provider "google" {
  credentials = file("harness-455805-service-account.json")
  project     = "harness-455805"
  zone        = "us-central1-a"
}

resource "google_container_cluster" "primary" {
  name     = "my-k8s-cluster"
  location = "us-central1-a"

  remove_default_node_pool = true
  initial_node_count       = 1

  ip_allocation_policy {}

  node_config {
    machine_type = "e2-medium"
    oauth_scopes = [
      "https://www.googleapis.com/auth/cloud-platform",
    ]
  }

  lifecycle {
    ignore_changes = [initial_node_count]
  }
}

resource "google_container_node_pool" "primary_nodes" {
  name       = "primary-node-pool"
  location   = "us-central1-a"
  cluster    = google_container_cluster.primary.name

  node_count = 2

  node_config {
    preemptible  = false
    machine_type = "e2-medium"
    oauth_scopes = [
      "https://www.googleapis.com/auth/cloud-platform",
    ]
  }
}
