
The `created_at` field records the **exact timestamp when a record was first inserted** into the database.

| Purpose                              | Description                                                                                                                       |
| ------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |
| 🕒 **Auditing & traceability**       | Know _when_ something (e.g., booking, user, payment, or hold) was created.                                                        |
| 📊 **Analytics & reporting**         | <span style="color:red;">Measure growth trends — bookings/day, users/week, etc.</span>                                            |
| ⚙️ **Debugging & troubleshooting**   | <span style="color:red;">Helps reconstruct events — “When did this hold start?” or “How long did it last before expiring?”</span> |
| 🔄 **TTL-based cleanup**             | Crucial for background jobs — e.g., expire holds after 15 minutes from `created_at`.                                              |
| 📦 **Data versioning & replication** | Sync only new or updated rows.                                                                                                    |
| 🔐 **Compliance / audit logs**       | Required for regulatory traceability in fintech or booking systems.                                                               |

---
