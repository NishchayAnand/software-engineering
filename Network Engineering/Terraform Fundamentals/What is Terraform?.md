
Allows you to provision networking & infra (infra-as-code)

- Use Terraform to define:

    - VPC, public/private subnets, NAT Gateway
    - Security groups for ALB, ECS tasks, RDS
    - RDS instance (Postgres) in private subnet, Multi-AZ for prod
    - ECR repos, IAM roles
    - ECS Cluster (Fargate) + Task Definitions + Services behind ALB
    - ACM certificate + Route53 records
    - CloudWatch log groups

This gives repeatable and reviewable infra.

---
