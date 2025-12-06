const nodemailer = require("nodemailer");

async function sendOtp(email) {
  const otp = Math.floor(100000 + Math.random() * 900000);

  const transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
     user: "ashishkumar.bcse2024@huroorkee.ac.in", // your Gmail
      pass: "ixzz glud lvpb bgns",
    },
  });

  const mailOptions = {
    from: "ashishkumar.bcse2024@huroorkee.ac.in",
    to: email,
    subject: "Your OTP Code",
    text:` Your OTP is ${otp} `,
  };

  try {
    await transporter.sendMail(mailOptions);
    console.log(`✅ OTP ${otp} sent to ${email}`);
    return otp; // agar OTP verify karna ho to return kar lo
  } catch (err) {
    console.error("❌ Error:", err);
  }
}

// module.exports = sendOtp;   // function export kiya



// const sendOtp = require("./otpMailer");

// kahin bhi call kar sakte ho
sendOtp("ashish224444q@gmail.com");