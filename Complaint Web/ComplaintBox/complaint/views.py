from django.shortcuts import render,render_to_response
from django.http import HttpResponse
from .models import Registration
from django import forms
import cgi
import os
import json
from django.conf import settings
from django.template import RequestContext, loader

# Create your views here.

def validate(request):
	return render(request, "complaint/index.html")

def validate1(request):
	email = request.POST.get('Username')
	password = request.POST.get('Password')
	password1 = request.POST.get('Password1') 

	if(password == password1):
		s = Registration(email = email, password = password)
		s.save()
		return HttpResponse('Registered Successfully')
	else:
		return HttpResponse('Password Mismatch')

def validate2(request):
	email = request.POST.get('Username')
	password = request.POST.get('Password')
	# return HttpResponse(email)
	if Registration.objects.filter(email = email, password = password):
		return render_to_response('complaint/index1.html')
	else:
		return HttpResponse('Invalid Login')
