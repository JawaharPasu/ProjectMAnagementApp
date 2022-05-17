# ProjectMAnagementApp
An app for project management

The program has been created on the following assumptions:
1. Only Known tasks(Resources) will be taken (I have not included the negative scenario -- if not known resource is added as task)
2. Users/tasks should be defined before passing them to the scheduler
3. Users will have their own skilllevel which will be used to calculate the speed in which they can perform the task
4. Once first task has been asigned, the users will be starting the execution of task on their speed
5. New Tasks can be added to the users while they are executing current tasks.
6. Scheduler plays the role of checking for the availability of licences and users who can achieve the completion of task in least possible time.

Pls check the comment section in Main to see how to create instances of the classes defined

Pls run the Main.java in any java development tools such as eclipse/Intelij

Check the logs in the console and check the items,
Logs are put for the following:
1. When task is assigned to user
2. When task can't be assigned
3. When user acquires a license
5. When user surrenders a licence
6. When user initates processing items in his plate
7. When user completes all the items in his plate

If a task is successfully added, the the message will read as follows:
task 1 is added to user having skillset : 0.5

If a task cannot be assigned then the message will read as follows:
WARNING: All users are occupied, task 6 is not possible to execute
