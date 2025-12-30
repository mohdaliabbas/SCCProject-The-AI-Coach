# SCCProject-The-AI-Coach
# AI-Assisted Engineer Growth Planner (Spring Boot)
## Overview
#### This project is a backend system designed to help engineers identify skill gaps, generate structured learning plans, track progress, and receive interview feedback.
<img width="414" height="523" alt="image" src="https://github.com/user-attachments/assets/9bb14dca-c2e2-4170-9db0-d51834483710" />
# Testable - API
<img width="715" height="704" alt="image" src="https://github.com/user-attachments/assets/3cf921f0-5f59-4bfa-8ce4-126ed395613c" />
<img width="573" height="652" alt="image" src="https://github.com/user-attachments/assets/023cfa12-d87e-457c-a231-8747c49484d4" />
<img width="636" height="713" alt="image" src="https://github.com/user-attachments/assets/651edb70-4341-4dc3-bf42-7a92fa4f5ddf" />
<img width="523" height="509" alt="image" src="https://github.com/user-attachments/assets/febb7d8b-4ad5-4ea6-9461-0c43b8676830" />

# The core design principle is decision clarity:
#### a.deterministic rules handle decisions 
#### b.APIs expose intent, not internals 
#### c.AI is used only for interpretation and explanation 
#### d.The system is built using Java + Spring Boot, with AI integrated as a controlled dependency rather than a decision-maker. 
# System Flow (High Level)
#### a.Engineer profile is created with experience and target role
#### b.Skills and current proficiency are captured
#### c.Rule engine identifies prioritized skill gaps
#### d.Weekly plans are generated deterministically
#### e.Daily progress is tracked as state
#### f.AI assists in explaining gaps and generating interview feedback
# Design Principles
#### a.Rules over predictions
#### b.Core decisions (skill gaps, plans) are rule-driven and testable.
#### c.Thin controllers, rich services
#### d.Controllers handle request/response only. Business logic lives in services.
#### e.Clear API boundaries
#### f.Planning, tracking, and evaluation are separated by intent.
#### g.AI as an assistant, not authority
#### h.AI explains decisions but never owns them.
# Core Capabilities
#### a.Engineer profile management
#### b.Skill gap analysis using rules
#### c.Weekly plan generation
#### d.Daily progress tracking
#### e.Interview answer evaluation with structured feedback
# API Overview (High Level)
# APIs are intentionally kept small and meaningful.
#### a.Create / update engineer profile
#### b.Add or update skills
#### c.Generate weekly learning plan
#### d.Track daily progress
#### e.Evaluate interview responses
#### f.Detailed API contracts and sample requests/responses are available in the API documentation.
# AI Integration
#### a.AI is used only in areas requiring interpretation:
#### b.explaining why a skill is considered a gap
#### c.generating interview feedback from structured signals
#### d.refining plan explanations within defined constraints
#### e.All AI calls are wrapped behind service boundaries with validated inputs and predictable outputs.
# Tech Stack
####### Java
####### Spring Boot
####### REST APIs
####### Rule-based decision logic
####### AI integration via service abstraction
#What I’d Improve Next
Stronger observability around decision execution
Versioning for rules and learning plans
Hardening APIs for broader external consumption
# Why This Project
This project was built to explore how clear boundaries, deterministic logic, and controlled AI usage can coexist in a scalable backend system.
The goal was not to build a “smart” system, but a understandable and explainable one.
