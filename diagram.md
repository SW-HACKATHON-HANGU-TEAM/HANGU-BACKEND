---
title: db diagram
---

```mermaid
erDiagram
    member ||--o{ usage_record : use
    member{
        int member_id PK
        int usage_record_id FK
        string email
        string password
        string user_rating
        string position
        string compony_name
        date birth_date
        int phone_number
        date created_at
        boolean is_active
    }
    usage_record {
        int usage_record_id PK
        date created_at
        int usage_count
    }
    
    page {
        int page_id PK
        string title
        MEDIUMTEXT content
        int parent_id 
    }
    
    folder {
        int folder_id PK
        string folder_name
        
    }
    

```



---
title: MongoDB
---

```json
{
  "project": {
    "project_id": 1,
    "directory": [
      {
        "directory_id": 1,
        "directory": [
          {
            
          }
        ],
        "file": [
          {
            "file_id": 1,
            "file_name": "sdf",
            "file_content": ""
          }
        ]
      }
    ]
  }
}
```
