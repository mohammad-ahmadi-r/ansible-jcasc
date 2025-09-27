# ansible-jcasc
This project provides a fully automated solution to deploy, configure, and manage Jenkins using Ansible and Jenkins Configuration as Code (JCasC). 

It handles everything from installing Java and Jenkins on a fresh server, to setting up plugins, creating secured pipeline jobs, managing credentials, and configuring multiple users with fine-grained permissions.

Pipelines are integrated with GitHub repositories and can be triggered both via webhooks and secure API tokens, enabling seamless CI/CD workflows.

## Features

✅ Automatic installation of Java and Jenkins on Ubuntu servers.

✅ Automatic installation of required Jenkins plugins.

✅ Jenkins Configuration as Code (JCasC) for managing:

	System settings
	Security and user management
	Pipeline jobs
	Credentials management

✅ Pipeline setup:

	Pulls Jenkinsfile from a GitHub repository.
	Triggerable via API calls using an auth token.
	Secured with user credentials for Git access.

✅ Ability to create multiple Jenkins users with different permissions.

---

## Prerequisites

- Ubuntu machine (tested on Ubuntu 22.04)
- SSH access to target machine
- Ansible installed on your control machine
- GitHub repository for your project code
- Optional: Ngrok (for external webhook testing)

---

## Run Ansible Playbook
```bash
ansible-playbook -i inventory.ini playbook.yml
```
or for testing:
```bash
ansible-playbook playbook.yml -i inventory.ini -vv --ask-become-pass --ask-pass
```

Remote call:
```bash
curl http://<jenkins-username>:<jenkins-password>@<jekins-node>:<jenkins-port>/job/<folder-name>/job/<job-name>/build\?token=<auth-token>
```
---
## Repository Structure

```bash
ansible-jenkins-setup/
├── inventory.yml
├── playbook.yml
├── roles/
│   └── jenkins/
│       ├── tasks/
│       ├── files/
│       └── defaults/
└── README.md
```