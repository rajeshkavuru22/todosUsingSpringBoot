variable "project_id" {
  description = "harness-455805"
  type        = string
}

variable "region" {
  description = "us-central1-a"
  type        = string
  default     = "us-central1"
}

variable "cluster_name" {
  description = "my cluster1"
  type        = string
  default     = "my-gke-cluster"
}

variable "node_count" {
  description = 2
  type        = number
  default     = 3
}
