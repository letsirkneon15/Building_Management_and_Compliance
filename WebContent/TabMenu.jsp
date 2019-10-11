    	<ul class="nav nav-tabs">
    		<c:if test="${not empty genInfoTab.tabDsp}">
  				<li class="active"><a data-toggle="tab" href="#GenInfo">
  				<h5 class="m-0 font-weight-bold text-primary">General <br> Information</h5></a></li>
  			</c:if>
  			<c:if test="${not empty contactsTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Contacts">
  				<h5 class="m-0 font-weight-bold text-primary">Contacts <br><br></h5></a></li>
  			</c:if>
  			<c:if test="${not empty wofTab.tabDsp}">
  				<li><a data-toggle="tab" href="#WOF">
  				<h5 class="m-0 font-weight-bold text-primary">WOF <br><br></h5></a></li>
  			</c:if>
  			<c:if test="${not empty consentTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Consent">
  				<h5 class="m-0 font-weight-bold text-primary">Building <br> Consent</h5></a></li>
  			</c:if>
  			<c:if test="${not empty asbestosTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Asbestos">
  				<h5 class="m-0 font-weight-bold text-primary">Asbestos <br><br></h5></a></li> 	
  			</c:if>
  			<c:if test="${not empty electricalTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Electrical">
  				<h5 class="m-0 font-weight-bold text-primary">Electrical <br><br></h5></a></li>	
  			</c:if>
  			<c:if test="${not empty gasTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Gas">
  				<h5 class="m-0 font-weight-bold text-primary">Gas<br><br></h5></a></li>	
  			</c:if>
  			<c:if test="${not empty fireTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Fire">
  				<h5 class="m-0 font-weight-bold text-primary">Fire<br><br></h5></a></li>	
  			</c:if>
  			<c:if test="${not empty hazSubsTab.tabDsp}">
  				<li><a data-toggle="tab" href="#HazSubs">
  				<h5 class="m-0 font-weight-bold text-primary">Hazardous <br> Substances</h5></a></li>
  			</c:if>
  			<c:if test="${not empty hazRegTab.tabDsp}">
  				<li><a data-toggle="tab" href="#HazReg">
  				<h5 class="m-0 font-weight-bold text-primary">Hazard <br> Register</h5></a></li>
  			</c:if>
  			<c:if test="${not empty seismicTab.tabDsp}">
  				<li><a data-toggle="tab" href="#Seismic">
  				<h5 class="m-0 font-weight-bold text-primary">Seismic <br> Resilience</h5></a></li>
  			</c:if>
  			<c:if test="${not empty resourceConsentTab.tabDsp}">
  				<li><a data-toggle="tab" href="#ResourceConsent">
  				<h5 class="m-0 font-weight-bold text-primary">Resource <br> Consents</h5></a></li>
  			</c:if>
  			<c:if test="${not empty comInsTab.tabDsp}">
  				<li><a data-toggle="tab" href="#ComIns">
  				<h5 class="m-0 font-weight-bold text-primary">Compliance <br> Inspection</h5></a></li>	
  			</c:if>	
		</ul>