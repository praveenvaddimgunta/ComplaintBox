from django.db import models

# Create your models here.
# class Login(models.Model):
#     email = models.EmailField(max_length=200)
#     password = models.CharField(max_length=200)


class Registration(models.Model):
    email = models.EmailField(max_length=200)
    password = models.CharField(max_length=200)
    def __unicode__(self):
    	return self.email

